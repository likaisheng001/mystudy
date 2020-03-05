package com.panda.study.designmodel_gp.proxy.dynamicproxy.gpproxy.proxy;/**
 * Created by My on 2020-03-02.
 */

import java.lang.reflect.Method;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 12:21:28 2020-03-02
 * @Modified By:
 */
public interface GPInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
