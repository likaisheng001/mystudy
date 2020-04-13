package com.panda.handwriting.spring30_v2.framework.webmvc.servlet;/**
 * Created by My on 2020-04-12.
 */

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 13:26:10 2020-04-12
 * @Modified By:
 */
public class PHandlerMapping {
    private Pattern pattern;
    private Method method;
    private Object controller; // method对应的实例对象

    public PHandlerMapping(Pattern pattern, Object controller, Method method) {
        this.pattern = pattern;
        this.method = method;
        this.controller = controller;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
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

}
