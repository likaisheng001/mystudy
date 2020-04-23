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
public class PAspectJAfterThrowingAdvice extends PAbstractAspectJAdvice implements PMethodInterceptor {
    private String throwName;

    public PAspectJAfterThrowingAdvice(Object aspect, Method adviceMethod) {
        super(aspect, adviceMethod);
    }

    @Override
    public Object invoke(PMethodInvocation mi) throws Throwable {
        try {
            return mi.proceed();
        } catch (Throwable ex){
            invokeAdviceMethod(mi,null,ex);
            throw ex;
        }
    }

    public void setThrowName(String throwName) {
        this.throwName = throwName;
    }
}
