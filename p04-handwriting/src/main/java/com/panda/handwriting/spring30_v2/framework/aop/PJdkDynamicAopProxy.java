package com.panda.handwriting.spring30_v2.framework.aop;/**
 * Created by My on 2020-04-13.
 */

import com.panda.handwriting.spring30_v2.framework.aop.aspect.PAdvice;
import com.panda.handwriting.spring30_v2.framework.aop.support.PAdvicedSupport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:35:18 2020-04-13
 * @Modified By:
 */
public class PJdkDynamicAopProxy implements InvocationHandler {
    private PAdvicedSupport config;

    public PJdkDynamicAopProxy(PAdvicedSupport config) {
        this.config = config;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Map<String, PAdvice> advices = config.getAdvices(method,null);

        Object returnValue;
        try {
            invokeAdvice(advices.get("before"));
            returnValue = method.invoke(this.config.getTarget(),args);
            invokeAdvice(advices.get("after"));
        } catch (Exception e){
            invokeAdvice(advices.get("afterThrow"));
            throw e;
        }
        return returnValue;
    }

    private void invokeAdvice(PAdvice advice) {
        try {
            advice.getAdviceMethod().invoke(advice.getAspect());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),this.config.getTargetClass().getInterfaces(),this);
    }
}
