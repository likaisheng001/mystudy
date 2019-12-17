package com.panda.spring2.framework.aop.aspect;/**
 * Created by My on 2019-12-17.
 */

import com.panda.spring2.framework.aop.intercept.GPMethodInterceptor;
import com.panda.spring2.framework.aop.intercept.GPMethodInvocation;

import java.lang.reflect.Method;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:11:05 2019-12-17
 * @Modified By:
 */
public class GPMethodBeforeAdviceInterceptor extends GPAbstarctAspectAdvice implements GPAdvice,GPMethodInterceptor {

    private GPJoinPoint joinPoint;

    public GPMethodBeforeAdviceInterceptor(Method aspectMethod, Object aspectTarget) {
        super(aspectMethod, aspectTarget);
    }

    private void before(Method method,Object[] args,Object target) throws Throwable{
        //传送给织入的参数
//        method.invoke(target);
        super.invokeAdviceMethod(this.joinPoint,null,null);
    }

    @Override
    public Object invoke(GPMethodInvocation mi) throws Throwable {
        //从被织入的代码中才能拿到，JoinPoint
        this.joinPoint = mi;
        before(mi.getMethod(),mi.getArguments(),mi.getThis());
        return mi.proceed();
    }
}
