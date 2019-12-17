package com.panda.spring2.framework.webmvc;/**
 * Created by My on 2019-12-16.
 */

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:02:09 2019-12-16
 * @Modified By:
 */
public class GPHandlerMappering {
    private Object controller;
    private Method method;
    private Pattern pattern; //URL的正则匹配

    public GPHandlerMappering(Pattern pattern,Object controller, Method method) {
        this.controller = controller;
        this.method = method;
        this.pattern = pattern;
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }
}
