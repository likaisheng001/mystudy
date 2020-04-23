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
public class PMethodBeforeAdviceInterceptor extends PAbstractAspectJAdvice implements PMethodInterceptor {

    private PJoinPoint jp;
    public PMethodBeforeAdviceInterceptor(Object aspect, Method adviceMethod) {
        super(aspect, adviceMethod);
    }
    public void before(Method method, Object[] arguments, Object aThis) throws Throwable {
        invokeAdviceMethod(this.jp,null,null);
    }

    @Override
    public Object invoke(PMethodInvocation mi) throws Throwable {
        jp = mi;
        this.before(mi.getMethod(),mi.getArguments(),mi.getThis());
        return mi.proceed();
    }

}
