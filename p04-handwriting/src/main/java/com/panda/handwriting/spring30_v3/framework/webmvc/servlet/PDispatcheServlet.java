package com.panda.handwriting.spring30_v3.framework.webmvc.servlet;/**
 * Created by My on 2020-04-05.
 */

import com.panda.handwriting.spring30_v3.framework.annotation.PController;
import com.panda.handwriting.spring30_v3.framework.annotation.PRequestMapping;
import com.panda.handwriting.spring30_v3.framework.context.PApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Likaisheng
 * @Description: 委派模式
 * GPDispatcheServlet的职责：负责任务调度，请求分发。
 * @Date: Created in 17:18:16 2020-04-05
 * @Modified By:
 */
public class PDispatcheServlet extends HttpServlet {
    private PApplicationContext applicationContext;
    private List<PHandlerMapping> handlerMappings = new ArrayList<PHandlerMapping>();
    private Map<PHandlerMapping, PHandlerAdapter> handlerAdapters = new HashMap<PHandlerMapping, PHandlerAdapter>();
    private List<PViewResolver> viewResolvers = new ArrayList<PViewResolver>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //6. 委派,根据URL去找到一个对应的Method并通过response返回

        try {
            doDispatch(req,resp);
        }catch (Exception e){
            e.printStackTrace();
            // resp.getWriter().write("500 Exception,Detail：" + Arrays.toString(e.getStackTrace()));
            try {
                processDispatcheResult(req,resp,new PModelAndView("500"));
            } catch (Exception ex) {
                ex.printStackTrace();
                resp.getWriter().write("500 Exception,Detail : " + Arrays.toString(e.getStackTrace()));
            }
        }

    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        // 完成了对HandlerMapping的封装
        // 完成了对方法返回值的封装ModelAndView

        //1. 通过URL获得一个HandlerMapping
        PHandlerMapping handler = getHandler(req);
        if (handler == null){
            processDispatcheResult(req,resp,new PModelAndView("404"));
            return;
        }

        //2. 根据一个HandlerMapping获得一个HandlerAdapter
        PHandlerAdapter ha = getHandlerAdapter(handler);

        //3. 解析某一个方法的形参和返回值之后，统一封装为ModelAndView对象
        PModelAndView mv = ha.handler(req,resp,handler);

        // 就是把ModelAndView变成一个ViewResolver
        processDispatcheResult(req,resp,mv);



    }

    private void processDispatcheResult(HttpServletRequest req, HttpServletResponse resp, PModelAndView mv) throws Exception {
        if (null == mv){return;}
        if (this.viewResolvers.isEmpty()){return;}
        for (PViewResolver viewResolver : this.viewResolvers){
            PView view = viewResolver.resolveViewName(mv.getViewName());
            //直接往浏览器输出
            view.render(mv.getModel(),req,resp);
        }
    }

    private PHandlerAdapter getHandlerAdapter(PHandlerMapping handler) {
        if (this.handlerAdapters.isEmpty()){return null;}
        return this.handlerAdapters.get(handler);
    }

    private PHandlerMapping getHandler(HttpServletRequest req) {
        if (this.handlerMappings.isEmpty()){return null;}

        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replaceAll(contextPath, "").replaceAll("/+", "/");

        for (PHandlerMapping mapping : handlerMappings){
            Matcher matcher = mapping.getPattern().matcher(url);
            if (!matcher.matches()){ continue;}
            return mapping;
        }
        return null;
    }

    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] +=32;
        return String.valueOf(chars);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //初始化Spring核心IoC容器
        applicationContext = new PApplicationContext(config.getInitParameter("contextConfigLocation"));

        // 完成了IoC、DI和MVC部分对接
        // 初始化九大组件
        initStrategies(applicationContext);
        System.out.println("GP Spring framework is init.");
    }

    /**
     * 初始化mvc九大组件
     * @param context
     */
    protected void initStrategies(PApplicationContext context){
        // handlerMapping
        initHandlerMappings(context);
        // 初始化参数适配器
        initHandlerAdapters(context);
        // 初始化视图转换器
        initViewResolvers(context);
    }

    private void initViewResolvers(PApplicationContext context) {
        String templateRoot = context.getConfig().getProperty("templateRoot");
        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();

        File templateRootDir = new File(templateRootPath);
        for (File file : templateRootDir.listFiles()){
            // FIXME 此处不太如意
            this.viewResolvers.add(new PViewResolver(templateRoot));
        }
    }

    private void initHandlerAdapters(PApplicationContext context) {
        for (PHandlerMapping handlerMapping : handlerMappings){
            this.handlerAdapters.put(handlerMapping,new PHandlerAdapter());
        }
    }

    private void initHandlerMappings(PApplicationContext context) {
        if (applicationContext.getBeanDefinitionCount() == 0){return;}

        for (String beanName : this.applicationContext.getBeanDefinitionNames()){

            Object instance = applicationContext.getBean(beanName);
            Class<?> clazz = instance.getClass();

            if (!clazz.isAnnotationPresent(PController.class)){continue;}

            String baseUrl = "";
            if (clazz.isAnnotationPresent(PRequestMapping.class)){
                PRequestMapping requestMapping = clazz.getAnnotation(PRequestMapping.class);
                baseUrl = requestMapping.value();
            }

            //只获取public的方法
            for (Method method : clazz.getMethods()){
                if (!method.isAnnotationPresent(PRequestMapping.class)){continue;}
                PRequestMapping requestMapping = method.getAnnotation(PRequestMapping.class);
                String regex = ("/" + baseUrl + "/" + requestMapping.value().replaceAll("\\*",".*")).replaceAll("/+","/");
                Pattern pattern = Pattern.compile(regex);
                handlerMappings.add(new PHandlerMapping(pattern,instance,method));
                System.out.println("Mapped:" + regex + "," + method);
            }
        }
    }
}
