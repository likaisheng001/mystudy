package com.panda.handwriting.spring30_v3.framework.aop.aspect;/**
 * Created by My on 2020-04-23.
 */

import com.panda.handwriting.spring30_v3.framework.aop.intercept.PMethodInterceptor;
import com.panda.handwriting.spring30_v3.framework.aop.intercept.PMethodInvocation;

import java.lang.reflect.Method;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:35:08 2020-04-23
 * @Modified By:
 */
public class PAfterReturningAdviceInterceptor extends PAbstractAspectJAdvice implements PMethodInterceptor {

    private PJoinPoint jp;
    public PAfterReturningAdviceInterceptor(Object aspect, Method adviceMethod) {
        super(aspect, adviceMethod);
    }

    @Override
    public Object invoke(PMethodInvocation mi) throws Throwable {

        jp = mi;
        Object retVal = mi.proceed();
        this.afterReturning(retVal, mi.getMethod(), mi.getArguments(), mi.getThis());
        return retVal;
    }


    protected void afterReturning(Object returnValue, Method method, Object[] args,Object target) throws Throwable {
        this.invokeAdviceMethod(this.jp,returnValue,null);
    }
}
