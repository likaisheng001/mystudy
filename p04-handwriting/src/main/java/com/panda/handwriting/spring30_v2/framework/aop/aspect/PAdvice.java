package com.panda.handwriting.spring30_v2.framework.aop.aspect;/**
 * Created by My on 2020-04-13.
 */

import lombok.Data;

import java.lang.reflect.Method;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:31:33 2020-04-13
 * @Modified By:
 */
@Data
public class PAdvice {
    private Method adviceMethod;
    private Object aspect;
    private String throwName;

    public PAdvice(Object aspect, Method adviceMethod) {
        this.adviceMethod = adviceMethod;
        this.aspect = aspect;
    }

    public Method getAdviceMethod() {
        return adviceMethod;
    }

    public void setAdviceMethod(Method adviceMethod) {
        this.adviceMethod = adviceMethod;
    }

    public Object getAspect() {
        return aspect;
    }

    public void setAspect(Object aspect) {
        this.aspect = aspect;
    }

    public String getThrowName() {
        return throwName;
    }

    public void setThrowName(String throwName) {
        this.throwName = throwName;
    }
}
