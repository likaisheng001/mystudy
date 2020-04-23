package com.panda.handwriting.spring30_v3.framework.aop.aspect;/**
 * Created by My on 2020-04-23.
 */

import java.lang.reflect.Method;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:40:43 2020-04-23
 * @Modified By:
 */
public abstract class PAbstractAspectJAdvice implements PAdvice{
    private Method adviceMethod;
    private Object aspect;
    private String throwName;

    public PAbstractAspectJAdvice(Object aspect, Method adviceMethod) {
        this.adviceMethod = adviceMethod;
        this.aspect = aspect;
    }

    protected Object invokeAdviceMethod(
            PJoinPoint joinPoint,
            Object returnValue, Throwable ex) throws Throwable {
        Class<?>[] parameterTypes = this.adviceMethod.getParameterTypes();
        if (null == parameterTypes || parameterTypes.length == 0){
            return this.adviceMethod.invoke(aspect);
        } else {
            Object[] args = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                if (parameterTypes[i] == PJoinPoint.class){
                    args[i] = joinPoint;
                } else if (parameterTypes[i] == Throwable.class){
                    args[i] = ex;
                } else if (parameterTypes[i] == Object.class){
                    args[i] = returnValue;
                }
            }
            return this.adviceMethod.invoke(aspect,args);
        }
    }
}
