package com.panda.spring2.framework.aop.aspect;/**
 * Created by My on 2019-12-17.
 */

import com.panda.spring2.framework.aop.intercept.GPMethodInterceptor;
import com.panda.spring2.framework.aop.intercept.GPMethodInvocation;

import java.lang.reflect.Method;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 21:21:54 2019-12-17
 * @Modified By:
 */
public class GPAroundAdviceInterceptor extends GPAbstarctAspectAdvice implements GPAdvice,GPMethodInterceptor {
    private GPJoinPoint joinPoint;

    public GPAroundAdviceInterceptor(Method aspectMethod, Object aspectTarget) {
        super(aspectMethod, aspectTarget);
    }

    @Override
    public Object invoke(GPMethodInvocation mi) throws Throwable {
        System.out.println("环绕之前");
        Object retVal = mi.proceed();
        mi.getMethod().invoke(mi.getThis());
        System.out.println("环绕之后");
        return retVal;
    }
}
