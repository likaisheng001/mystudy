package com.panda.handwriting.spring300;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 09:50:58 2019-12-22
 * @Modified By:
 */

public class PDispatcherServlet extends HttpServlet{
    //保存application.properties配置文件中的内容
    private Properties contextConfig = new Properties();
    //保存扫描得到的类名
    private List<String> classNames = new ArrayList<String>();
    private Map<String,Object> ioc = new HashMap<String,Object>();
    private Map<String,Method> handlerMapping = new HashMap<String,Method>();

    private final String SERVLET_INIT_PARAM_NAME = "contextConfigLocation";
    private final String SCAN_PACKAGE = "scanPackage";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatcher(req,resp);
    }

    private void doDispatcher(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatcher(req,resp);
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
        System.out.println("Panda Spring framework is init.");
    }

    private void initHandlerMapper() {

    }

    private void doAutowired() {

    }

    private void doInstance() {
        
    }

    private void doScanner(String property) {
        
    }

    private void doLoadConfig(String initParameter) {
        
    }
}
