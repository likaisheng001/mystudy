package com.panda.handwriting.spring30_v3.framework.aop;/**
 * Created by My on 2020-04-23.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 14:25:22 2020-04-23
 * @Modified By:
 */
public interface PAopProxy {
    Object getProxy();
    Object getProxy(ClassLoader classLoader);
}
