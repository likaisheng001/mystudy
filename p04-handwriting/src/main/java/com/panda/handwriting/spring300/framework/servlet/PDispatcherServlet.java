package com.panda.handwriting.spring300.framework.servlet;

import com.panda.handwriting.spring300.framework.annotation.*;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 09:50:58 2019-12-22
 * @Modified By:
 */
// FIXME 程序启动时，无法初始化
@Slf4j
public class PDispatcherServlet extends HttpServlet{
    //保存application.properties配置文件中的内容
    private Properties contextConfig = new Properties();
    //保存扫描得到的类名
    private List<String> classNames = new ArrayList<String>();
    private Map<String,Object> ioc = new HashMap<String,Object>();
    //private Map<String,Method> handlerMapping = new HashMap<String,Method>();
    //为什么不用Map ?
    //你用Map的话，key只能是url
    //HandlerMapping本身的功能就是保存Url和method对应关系  --  根据设计原则：冗余的感觉，单一职责，最少知道原则，帮助我们更好的理解
    //从性能上来说，与其交给Map去遍历，还不如自己直接遍历
    private List<HandlerMapping> handlerMapping = new ArrayList<HandlerMapping>();

    private final String SERVLET_INIT_PARAM_NAME = "contextConfigLocation";
    private final String SCAN_PACKAGE = "scanPackage";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replaceAll(contextPath,"").replaceAll("/+","/");

        HandlerMapping handlerMapping =  getHandler(req);
        if (handlerMapping == null){
            resp.getWriter().write("404 Not Found!!!");
            return;
        }

        /*// FIXME 这种匹配方式，无法处理通配符的情况 例如:/demo/query.*
        if (!this.handlerMapping.containsKey(url)){
            resp.getWriter().write("404 Not Found");
            return;
        }*/
        // Method method = this.handlerMapping.get(url);
        // String beanName = toLowerFirstCase(method.getDeclaringClass().getSimpleName());
        /*// 写死请求参数
        Map<String,String[]> params = req.getParameterMap();
        method.invoke(ioc.get(beanName),new Object[]{req,resp,params.get("name")[0]});*/

        /*// 这种动态处理参数的方法不灵活又复杂
        Map<String,String[]> params = req.getParameterMap();

        Class<?>[] parameterTypes = method.getParameterTypes();
        Object[] paramValues = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++){
            Class parameterType = parameterTypes[i];
            if (parameterType == HttpServletRequest.class){
                paramValues[i] = req;
                continue;
            }else if (parameterType == HttpServletResponse.class){
                paramValues[i] = resp;
                continue;
            }

            // 把方法上的注解拿到，得到的是一个二维数组 -- 一个参数可能有多个注解
            Annotation[][] pa = method.getParameterAnnotations();
            for (int j = 0; j < pa.length; j++){
                // 处理第一个带注解的参数
                for (Annotation a : pa[i]){
                    if (a instanceof PRequestParam){
                        String paramName = ((PRequestParam) a).value();
                        // 此段代码太晕车，考虑改变思路
                        // FIXME 暂时不处理这种情况，假设所有@PRequestParam注解都有值
                        if ("".equals(paramName.trim())){break;}

                        if (params.containsKey(paramName)){
                            String[] strs = params.get(paramName);
                            //FIXME 此处也不做过多处理,假设如此
                            // http://localhost/web/query.json?name=vulcan&name=Tom 这种传参，会导致参数丢失
                            paramValues[i] = strs[0];
                        }
                    }
                }
            }
            method.invoke(ioc.get(beanName),paramValues);
        }*/

        // 动态获取方法的参数
        Class<?>[] paramTypes = handlerMapping.getParamTypes();
        Object[] paramValues = new Object[paramTypes.length];

        Map<String,String[]> params = req.getParameterMap();
        for (Map.Entry<String,String[]> param : params.entrySet()){
            String value = Arrays.toString(param.getValue()).replaceAll("\\[|\\]","")
                    .replaceAll("\\s",",");
            if (!handlerMapping.paramIndexMapping.containsKey(param.getKey())){continue;}
            int index = handlerMapping.paramIndexMapping.get(param.getKey());
            paramValues[index] = convert(paramTypes[index],value);
        }
        if (handlerMapping.paramIndexMapping.containsKey(HttpServletRequest.class.getName())){
            int reqIndex = handlerMapping.paramIndexMapping.get(HttpServletRequest.class.getName());
            paramValues[reqIndex] = req;
        }

        if (handlerMapping.paramIndexMapping.containsKey(HttpServletResponse.class.getName())){
            int respIndex = handlerMapping.paramIndexMapping.get(HttpServletResponse.class.getName());
            paramValues[respIndex] =resp;
        }

        Object returnValue = handlerMapping.method.invoke(handlerMapping.controller,paramValues);
        if (returnValue == null || returnValue instanceof Void){return;}
        resp.getWriter().write(returnValue.toString());
    }
    // FIXME 这段代码不复合开闭原则
    //url传过来的参数都是String类型的，Http是基于字符串协议
    //只需要把String转换为任意类型就好
    private Object convert(Class<?> type,String value){
        if (Integer.class == type){
            return Integer.valueOf(value);
        }else if (Double.class == type){
            return Double.valueOf(value);
        }
        //如果还有double或者其他类型，继续加if
        //这时候，我们应该想到策略模式了 -- 在这里暂时不实现
        return value;
    }
    private HandlerMapping getHandler(HttpServletRequest req) {
        if (handlerMapping.isEmpty()){return null;}
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replaceAll(contextPath,"").replaceAll("/+","/");

        for (HandlerMapping mapping : this.handlerMapping){
            Matcher matcher = mapping.getUrl().matcher(url);
            if (!matcher.matches()){continue;}
            return mapping;
        }
        return null;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req,resp);
        }catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("500 Execution,Detail:" + Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //1. 加载配置文件
        doLoadConfig(config.getInitParameter(SERVLET_INIT_PARAM_NAME));
        //2. 扫描相关的类
        doScanner(contextConfig.getProperty(SCAN_PACKAGE));
        //3. 初始化类(初始化扫描到的类，并把它们放入IOC容器)
        doInstance();
        //4. 依赖注入(遍历IOC容器，根据@Autowired注解进行判断注入)
        doAutowired();
        //5. 初始化HandlerMapping
        initHandlerMapper();
        //log.info("Panda Spring framework is init.");
        System.out.println("Panda Spring framework is init.");
    }

    private void initHandlerMapper() {
        if (ioc.isEmpty()){return;}
        for (Map.Entry<String,Object> entry : ioc.entrySet()){
            Class<?> clazz = entry.getValue().getClass();
            if (!clazz.isAnnotationPresent(PController.class)){continue;}
            String baseUrl = "";
            if (clazz.isAnnotationPresent(PRequestMapping.class)){
                PRequestMapping requestMapping = clazz.getAnnotation(PRequestMapping.class);
                baseUrl = requestMapping.value();
            }
            //默认获取所有的public方法
            for (Method method : clazz.getMethods()){
                if (!method.isAnnotationPresent(PRequestMapping.class)){continue;}
                PRequestMapping requestMapping = method.getAnnotation(PRequestMapping.class);

                //String url = ("/" +baseUrl + "/" + requestMapping.value()).replaceAll("/+","/");
                //handlerMapping.put(url,method);
                //log.info("Mapped:" + url + "," + method);

                String regex = ("/" +baseUrl + "/" + requestMapping.value()).replaceAll("/+","/");
                Pattern pattern = Pattern.compile(regex);
                this.handlerMapping.add(new HandlerMapping(pattern,entry.getValue(),method));

                System.out.println("Mapped:" + pattern + "," + method);
            }
        }
    }

    private void doAutowired() {
        if (ioc.isEmpty()){return;}
        for (Map.Entry<String,Object> entry : ioc.entrySet()){
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields){
                if (!field.isAnnotationPresent(PAutowired.class)){continue;}
                PAutowired autowired = field.getAnnotation(PAutowired.class);
                String beanName = autowired.value().trim();
                if ("".equals(beanName)){
                    // FIXME 此处确定是首字母小写的格式吗？ - 首字母小写
                    beanName = field.getType().getName();
                }
                field.setAccessible(true);
                try {
                    // TODO 反射，动态给字段赋值是这样写的吗？
                    field.set(entry.getValue(),ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doInstance() {
        if (classNames.isEmpty()){return;}
        try {
            for (String className : classNames){
                Class<?> clazz = Class.forName(className);

                if (clazz.isAnnotationPresent(PController.class)){
                    Object instance = clazz.newInstance();
                    String beanName = toLowerFirstCase(clazz.getSimpleName());
                    ioc.put(beanName,instance);
                }else if (clazz.isAnnotationPresent(PService.class)){
                    PService service = clazz.getAnnotation(PService.class);
                    String beanName = service.value();
                    if ("".equals(beanName)){
                        beanName = toLowerFirstCase(clazz.getSimpleName());
                    }
                    Object instance = clazz.newInstance();
                    ioc.put(beanName,instance);

                    // 对于接口处理
                    for (Class<?> i : clazz.getInterfaces()){
                        if (ioc.containsKey(i.getName())){
                            throw new Exception("The " + i.getName() + " is exists!");
                        }
                        // TODO 此处需注意i.getName() 是否首字母小写
                        ioc.put(i.getName(),instance);
                    }
                }else{
                    continue;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void doScanner(String scanPackage) {
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classPath = new File(url.getFile());
        for (File file : classPath.listFiles()){
            if (file.isDirectory()){
                doScanner(scanPackage+"."+file.getName());
            }else {
                if (!file.getName().endsWith(".class")){
                    continue;
                }
                //保存类的全限定名
                String className = (scanPackage + "." + file.getName().replace(".class",""));
                classNames.add(className);
            }
        }
    }

    private void doLoadConfig(String contextConfigLocation) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation.replace("classpath:", ""));
        try {
            contextConfig.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null)
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //如果类名本身是小写字母，确实会出问题
    //但是我要说明的是，这个方法是我自己用的，private的
    private String toLowerFirstCase(String simpleName){
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
    // 保存url和method的对应关系
    public class HandlerMapping{
        private Pattern url; // 正则
        private Method method;
        private Object controller;
        private Class<?>[] paramTypes;

        // 参数的名字作为key,参数的位置作为值
        private Map<String,Integer> paramIndexMapping;

        public HandlerMapping(Pattern url, Object controller, Method method) {
            this.url = url;
            this.method = method;
            this.controller = controller;
            this.paramTypes = method.getParameterTypes();

            paramIndexMapping = new HashMap<String,Integer>();
            putParamIndexMapping(method);
        }

        private void putParamIndexMapping(Method method) {
            /**
             * 提取方法中有注解的参数，把方法上的注解拿到，得到的是一个二维数组
             * 注意：一个字段可以有多个注解，而一个方法又可以有多个参数
             */
            Annotation[][] pa = method.getParameterAnnotations();
            for (int i = 0; i < pa.length; i++){
                // 处理第一个参数
                for (Annotation a : pa[i]){
                    if (a instanceof PRequestParam){
                        String paramName = ((PRequestParam) a).value();
                        // FIXME 暂不处理为空的情况
                        if (!"".equals(paramName.trim())){
                            paramIndexMapping.put(paramName,i);
                        }
                    }
                }
            }
            // 提取方法中的request和response参数
            Class<?>[] paramsTypes = method.getParameterTypes();
            for (int i = 0 ; i < paramsTypes.length; i++){
                Class<?> type = paramsTypes[i];
                if (type == HttpServletRequest.class || type == HttpServletResponse.class ){
                    // TODO 此处的name是参数类型 ???
                    paramIndexMapping.put(type.getName(),i);
                }
            }
        }

        public Pattern getUrl() {
            return url;
        }

        public void setUrl(Pattern url) {
            this.url = url;
        }

        public Method getMethod() {
            return method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }

        public Object getController() {
            return controller;
        }

        public void setController(Object controller) {
            this.controller = controller;
        }

        public Class<?>[] getParamTypes() {
            return paramTypes;
        }

        public void setParamTypes(Class<?>[] paramTypes) {
            this.paramTypes = paramTypes;
        }

        public Map<String, Integer> getParamIndexMapping() {
            return paramIndexMapping;
        }

        public void setParamIndexMapping(Map<String, Integer> paramIndexMapping) {
            this.paramIndexMapping = paramIndexMapping;
        }
    }
}
