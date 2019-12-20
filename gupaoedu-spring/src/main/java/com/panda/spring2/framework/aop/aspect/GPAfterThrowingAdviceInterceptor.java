package com.panda.spring2.framework.aop.aspect;

import com.panda.spring2.framework.aop.intercept.GPMethodInterceptor;
import com.panda.spring2.framework.aop.intercept.GPMethodInvocation;

import java.lang.reflect.Method;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:15:36 2019-12-17
 * @Modified By:
 */
public class GPAfterThrowingAdviceInterceptor extends GPAbstarctAspectAdvice implements GPAdvice,GPMethodInterceptor {

    private String throwingName;

    public GPAfterThrowingAdviceInterceptor(Method aspectMethod, Object aspectTarget) {
        super(aspectMethod, aspectTarget);
    }

    @Override
    public Object invoke(GPMethodInvocation mi) throws Throwable {
        try{
            return mi.proceed();
        }catch (Throwable e){
            invokeAdviceMethod(mi,null,e.getCause());
            throw e;
        }
    }

    public void setThrowName(String throwName){
        this.throwingName = throwName;
    }
}
