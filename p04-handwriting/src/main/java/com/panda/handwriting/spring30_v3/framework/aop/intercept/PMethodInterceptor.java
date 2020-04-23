package com.panda.handwriting.spring30_v3.framework.aop.intercept;/**
 * Created by My on 2020-04-23.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:09:14 2020-04-23
 * @Modified By:
 */
public interface PMethodInterceptor {
    Object invoke(PMethodInvocation invocation) throws Throwable;
}
