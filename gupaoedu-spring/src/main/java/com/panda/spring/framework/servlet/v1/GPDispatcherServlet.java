package com.panda.spring.framework.servlet.v1;/**
 * Created by My on 2019-11-30.
 */

import com.panda.spring.framework.annotation.GPAutowired;
import com.panda.spring.framework.annotation.GPController;
import com.panda.spring.framework.annotation.GPRequestMapping;
import com.panda.spring.framework.annotation.GPService;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * @Author: Likaisheng
 * @Description: 该GPDispatcherServlet已经能实现功能了，但还无法动态获取形参列表及动态赋值
 * @Date: Created in 13:11:50 2019-11-30
 * @Modified By:
 */
public class GPDispatcherServlet extends HttpServlet{
    //保存application.properties配置文件中的内容
    private  Properties contextConfig = new Properties();
    //保存扫描得到的类名
    private List<String> classNames = new ArrayList<String>();
    //传说中的IOC容器,为了简化程序，暂时不考虑ConcurrentHashMap
    private Map<String,Object> ioc = new HashMap<String,Object>();
    //保存url和Method的对应关系
    private Map<String,Method> handlerMapping = new HashMap<String,Method>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        //1. 加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));
        //2. 扫描相关的类
        doScanner(contextConfig.getProperty("scanPackage"));
        //3. 初始化扫描到的类，并且将它们放入到IOC容器之中
        doInstance();
        //4. 完成依赖注入
        doAutowired();
        //5. 初始化HandlerMapping
        initHandlerMapper();
        System.out.println("GP Spring framework is init");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            doDispatch(req,resp);
        }catch (Exception e){
            e.printStackTrace();
            resp.getWriter().write("500 Exection,Detail : " + Arrays.toString(e.getStackTrace()));
        }

    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {
        //绝对路径
        String url = req.getRequestURI();
        //处理成相对路径
        String contextPath = req.getContextPath();
        url.replaceAll(contextPath,"").replaceAll("/+","/");
        if (!this.handlerMapping.containsKey(url)){
            resp.getWriter().write("404 Not Found!");
            return;
        }
        Method method = this.handlerMapping.get(url);
        //投机取巧的方式
        //通过反射拿到method所在的class，拿到class之后还是拿到class的name
        String beanName = toLowerFirstCase(method.getDeclaringClass().getSimpleName());
        //为了投机取巧，暂时写死
        Map<String,String[]> params = req.getParameterMap();


        method.invoke(ioc.get(beanName),new Object[]{req,resp,params.get("name")[0]});
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            doDispatch(req,resp);
        }catch (Exception e){
            e.printStackTrace();
            resp.getWriter().write("500 Exection,Detail : " + Arrays.toString(e.getStackTrace()));
        }
    }
    //初始化url和Method的一对一的对应关系
    private void initHandlerMapper() {
        if(ioc.isEmpty()){return;};
        for (Map.Entry<String,Object> entry : ioc.entrySet()){
            Class<?> clazz = entry.getValue().getClass();
            if (!clazz.isAnnotationPresent(GPController.class)){ continue;};
            //保存写在类上面@GPRequestMapping("/demo")
            String baseUrl = "";
            if(clazz.isAnnotationPresent(GPRequestMapping.class)){
                GPRequestMapping requestMapping = clazz.getAnnotation(GPRequestMapping.class);
                baseUrl = requestMapping.value();
            }
            //默认获取所有的public方法
            for (Method method : clazz.getMethods()){
                if (!method.isAnnotationPresent(GPRequestMapping.class)){return;};
                GPRequestMapping requestMapping = method.getAnnotation(GPRequestMapping.class);
                //优化 /demo/query

                String url = (baseUrl + "/" + requestMapping.value()).replaceAll("/+","/");
                handlerMapping.put(url,method);
                System.out.println("Mapped :" + url + "," + method);
            }
        }
    }

    private void doAutowired() {
        if (ioc.isEmpty()){return;};
        for (Map.Entry<String,Object> entry : ioc.entrySet()){
            //DeclaredFields 所有的字段
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields){
                if (!field.isAnnotationPresent(GPAutowired.class)){continue;}
                GPAutowired autowired = field.getAnnotation(GPAutowired.class);
                //如果用户没有自定义beanName,默认就根据类型注入
                //这个地方省去了对类名首字母小写的情况的判断 -- 课后作业
                String beanName = autowired.value().trim();
                if("".equals(beanName)){
                    beanName = field.getType().getName();
                }
                //如果是public以外的修饰符，只要加了GPAutowired注解，都要强制赋值
                //反射中叫做暴力访问
                field.setAccessible(true);
                try {
                    //用反射机制，动态给字段赋值
                    field.set(entry.getValue(),ioc.get(beanName));
                }catch (IllegalAccessException e){
                    e.printStackTrace();
                }

            }
        }
    }

    private void doInstance() {
        //初始化，为DI做准备
        if (classNames.isEmpty()){ return;}
        try{
            for (String className : classNames){
                Class<?> clazz = Class.forName(className);
                //什么样的类才需要初始化
                //加了注解的类，才初始化，怎么判断？
                //为了简化代码逻辑，主要体会设计思想，@Componment
                if (clazz.isAnnotationPresent(GPController.class)){
                    Object instance = clazz.newInstance();
                    //Spring默认类名首字母小写
                    String beanName = toLowerFirstCase(clazz.getSimpleName());
                    ioc.put(beanName,instance);
                }else if(clazz.isAnnotationPresent(GPService.class)){
                    //1.自定义的beanName
                    GPService service =clazz.getAnnotation(GPService.class);
                    String beanName = service.value();
                    //2. 默认类名首字母小写
                    if("".equals(beanName)){
                        beanName = toLowerFirstCase(clazz.getSimpleName());
                    }
                    //3. 根据类型自动赋值 -- 投机取巧的方式
                    Object instance = clazz .newInstance();
                    ioc.put(beanName,instance);
                    for (Class<?> i : clazz.getInterfaces()){
                        if(ioc.containsKey(i.getName())){
                            throw new Exception("The " + i.getName() + " is exists!");
                        }
                        ioc.put(i.getName(),instance);
                    }
                }else{
                    continue;
                }
            }
        }catch (Exception e){

        }
    }
    //如果类名本身是小写字母，确实会出问题
    //但是我要说明的是，这个方法是我自己用的，private的
    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    private void doScanner(String scanPackage) {
        //com.panda.demo 转换为文件路径
        URL url = this.getClass().getClassLoader().getResource("/"+scanPackage.replaceAll("\\.","/"));
        File classPath = new File(url.getFile());
        for (File file : classPath.listFiles()){
            if(file.isDirectory()){
                doScanner(scanPackage+"."+file.getName());
            }else{
                if(!file.getName().endsWith(".class")){
                    continue;
                }
                String className = (scanPackage + "." + file.getName().replace(".class",""));
                classNames.add(className);
            }
        }
    }

    //加载配置文件
    private void doLoadConfig(String contextConfigLocation) {

        InputStream fis = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation.replaceAll("classpath:",""));
        try {
            contextConfig.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != fis){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
