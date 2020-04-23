package com.panda.handwriting.spring30_v3.framework.aop;/**
 * Created by My on 2020-04-13.
 */


import com.panda.handwriting.spring30_v3.framework.aop.intercept.PMethodInvocation;
import com.panda.handwriting.spring30_v3.framework.aop.support.PAdvicedSupport;

import java.lang.reflect.InvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:35:18 2020-04-13
 * @Modified By:
 */
public class PJdkDynamicAopProxy implements PAopProxy,InvocationHandler {
    private PAdvicedSupport advised;

    public PJdkDynamicAopProxy(PAdvicedSupport advised) {
        this.advised = advised;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        List<Object> chain = this.advised.getInterceptorsAndDynamicInterceptionAdvice(method,this.advised.getTargetClass());

        PMethodInvocation mi = new PMethodInvocation(proxy, this.advised.getTarget(), method, args, this.advised.getTargetClass(), chain);

        return mi.proceed();
    }

    public Object getProxy() {
        return getProxy(this.getClass().getClassLoader());
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return Proxy.newProxyInstance(classLoader, this.advised.getTargetClass().getInterfaces(), this);
    }
}
