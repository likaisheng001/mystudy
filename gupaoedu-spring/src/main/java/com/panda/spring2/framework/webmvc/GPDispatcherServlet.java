package com.panda.spring2.framework.webmvc;/**
 * Created by My on 2019-12-15.
 */


import com.panda.spring2.framework.annotation.GPController;
import com.panda.spring2.framework.annotation.GPRequestMapping;
import com.panda.spring2.framework.context.GPApplicationContext;
import lombok.extern.slf4j.Slf4j;

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
 * @Description:
 * @Date: Created in 12:03:23 2019-12-15
 * @Modified By:
 */
@Slf4j
public class GPDispatcherServlet extends HttpServlet {
    private GPApplicationContext context;
    private final String  CONTEXT_CONFIG_LOCATION = "contextConfigLocation";
    private List<GPHandlerMappering> handlerMappings = new ArrayList<GPHandlerMappering>();
    private Map<GPHandlerMappering,GPHandlerAdapter> handlerAdapters = new HashMap<GPHandlerMappering,GPHandlerAdapter>();
    private List<GPViewResolver> viewResolvers = new ArrayList<GPViewResolver>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.doDispatch(req,resp);
        }catch (Exception e){
            //processDispatchResult(req,resp,new GPModelAndView("404"));
            resp.getWriter().write("500 Exception,Details:\r\n"+ Arrays.toString(e.getStackTrace()));
            e.printStackTrace();
        }

    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1. 通过从request中拿到URL,去匹配一个HandlerMapping
        GPHandlerMappering handler = this.getHandler(req);
        if (handler == null){
            processDispatchResult(req,resp,new GPModelAndView("404"));
            return;
        }
        //2. 准备调用前的参数
        GPHandlerAdapter ha =  getHandlerAdapter(handler);
        //3. 真正的调用方法，返回ModelAndView存储了要传到页面上的值和页面模板的名称
        GPModelAndView mv = ha.handle(req,resp,handler);
        //这一步才是真正的输出
        processDispatchResult(req,resp,mv);
    }

    private void processDispatchResult(HttpServletRequest req, HttpServletResponse resp, GPModelAndView mv) throws Exception {
        //把给我的ModelAndView变成一个HTML、OoutputStream、json、freemark、velocity
        //ContextType
        if (null == mv){
            return;
        }
        //如果ModelAndView不为null,怎么办？
        if (this.viewResolvers.isEmpty()){
            return;
        }
        for (GPViewResolver viewResolver : this.viewResolvers){
           GPView view = viewResolver.resolveViewName(mv.getViewName(),null);
           view.render(mv.getModel(),req,resp);
           return;
        }
    }

    private GPHandlerAdapter getHandlerAdapter(GPHandlerMappering handler) {
        if (this.handlerAdapters.isEmpty()){return null;}

        GPHandlerAdapter ha = this.handlerAdapters.get(handler);
        if(ha.supports(handler)){
            return ha;
        }
        return null;
    }

    private GPHandlerMappering getHandler(HttpServletRequest req)throws Exception{
        if (this.handlerMappings.isEmpty()){
            return null;
        }
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url.replaceAll(contextPath,"").replaceAll("/+","/");

        for (GPHandlerMappering handler : this.handlerMappings){
            try {
                Matcher matcher = handler.getPattern().matcher(url);
                if (!matcher.matches()){
                    continue;
                }
                return handler;
            }catch (Exception e){
                throw e;
            }
        }
        return null;
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        //1. 初始化ApplicationContext
        context = new GPApplicationContext(config.getInitParameter(CONTEXT_CONFIG_LOCATION));
        //2. 初始化Spring MVC 九大组件
        initStrategies(context);
    }

    //初始化策略
    protected void initStrategies(GPApplicationContext context) {
        //多文件上传的组件
        initMultipartResolver(context);
        //初始化本地语言环境
        initLocaleResolver(context);
        //初始化模板处理器
        initThemeResolver(context);
        //handlerMapping:必须实现
        initHandlerMappings(context);
        //初始化参数适配器：必须实现
        initHandlerAdapters(context);
        //初始化异常拦截器
        initHandlerExceptionResolvers(context);
        //初始化视图预处理器
        initRequestToViewNameTranslator(context);
        //初始化视图转换器：必须实现
        initViewResolvers(context);
        //参数缓存器
        initFlashMapManager(context);
    }

    private void initFlashMapManager(GPApplicationContext context) {

    }

    private void initViewResolvers(GPApplicationContext context) {
        //拿到模板的存储目录
        String templateRoot = context.getConfig().getProperty("templateRoot");
        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();
        File templateRootDir = new File(templateRootPath);
        String[] templates = templateRootDir.list();
        for (int i = 0; i < templates.length; i++){
            //这里主要是为了兼容多模板，所有模板Spring用List保存
            //在我写的代码中简化了，其实只要有一个模板就可以搞定
            //只是为了仿真，所有还是搞了个List
            this.viewResolvers.add(new GPViewResolver(templateRoot));
        }

        for (File template : templateRootDir.listFiles()){
            this.viewResolvers.add(new GPViewResolver(templateRoot));
        }
    }

    private void initRequestToViewNameTranslator(GPApplicationContext context) {

    }

    private void initHandlerExceptionResolvers(GPApplicationContext context) {

    }

    private void initHandlerAdapters(GPApplicationContext context) {
        //把一个request请求变成一个Handler,参数都是字符串的，自动匹配到handler中的形参
        //可想而知，他要拿到HandlerMapping才能干活
        //就意味着有几个HandlerMapper就有几个HandlerAdapter
        for (GPHandlerMappering handlerMappering : this.handlerMappings){
            this.handlerAdapters.put(handlerMappering,new GPHandlerAdapter());
        }
    }

    private void initHandlerMappings(GPApplicationContext context) {
        String[] beanNames = context.getBeanDefinitionNames();
        try {
            for (String beanName:beanNames){
                Object controller = context.getBean(beanName);
                Class<?> clazz = controller.getClass();
                if (!clazz.isAnnotationPresent(GPController.class)){
                    continue;
                }

                String baseUrl = "";
                if(clazz.isAnnotationPresent(GPRequestMapping.class)){
                    GPRequestMapping requestMapping = clazz.getAnnotation(GPRequestMapping.class);
                    baseUrl = requestMapping.value();
                }
                //默认获取所有的public方法
                for (Method method : clazz.getMethods()){
                    if (!method.isAnnotationPresent(GPRequestMapping.class)){continue;};
                    GPRequestMapping requestMapping = method.getAnnotation(GPRequestMapping.class);
                    //优化 /demo/query

                    String regex = ("/" + baseUrl + "/" + requestMapping.value().replaceAll("\\*",".*")).replaceAll("/+","/");
                    Pattern pattern = Pattern.compile(regex);
                    this.handlerMappings.add(new GPHandlerMappering(pattern,controller,method));
                    //handlerMapping.put(url,method);
                    log.info("Mapped :" + regex + "," + method);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initThemeResolver(GPApplicationContext context) {

    }

    private void initLocaleResolver(GPApplicationContext context) {

    }

    private void initMultipartResolver(GPApplicationContext context) {

    }
}
