package com.panda.spring2.framework.aop.intercept;/**
 * Created by My on 2019-12-17.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 14:46:31 2019-12-17
 * @Modified By:
 */
public interface GPMethodInterceptor {
    Object invoke(GPMethodInvocation invocation) throws Throwable;
}
