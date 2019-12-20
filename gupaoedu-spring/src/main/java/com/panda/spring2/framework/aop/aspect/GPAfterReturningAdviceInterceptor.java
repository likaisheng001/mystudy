package com.panda.spring2.framework.aop.aspect;/**
 * Created by My on 2019-12-17.
 */

import com.panda.spring2.framework.aop.intercept.GPMethodInterceptor;
import com.panda.spring2.framework.aop.intercept.GPMethodInvocation;

import java.lang.reflect.Method;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:11:36 2019-12-17
 * @Modified By:
 */
public class GPAfterReturningAdviceInterceptor extends GPAbstarctAspectAdvice implements GPAdvice,GPMethodInterceptor {

    private GPJoinPoint joinPoint;

    public GPAfterReturningAdviceInterceptor(Method aspectMethod, Object aspectTarget) {
        super(aspectMethod, aspectTarget);
    }

    @Override
    public Object invoke(GPMethodInvocation mi) throws Throwable {
        Object retVal = mi.proceed();
        this.joinPoint = mi;
        this.afterReturning(retVal,mi.getMethod(),mi.getArguments(),mi.getThis());

        return retVal;
    }

    private void afterReturning(Object retVal, Method method, Object[] arguments, Object aThis) throws Throwable {
        super.invokeAdviceMethod(this.joinPoint,retVal,null);
    }
}
