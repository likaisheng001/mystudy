package com.panda.spring2.framework.aop;/**
 * Created by My on 2019-12-17.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 13:42:43 2019-12-17
 * @Modified By:
 */
public interface GPAopProxy {
    Object getProxy();
    Object getProxy(ClassLoader classLoader);
}
