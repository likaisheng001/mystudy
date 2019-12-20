package com.panda.spring2.framework.aop;/**
 * Created by My on 2019-12-17.
 */

import com.panda.spring2.framework.aop.support.GPAdvisedSupport;

/**
 * @Author: Likaisheng
 * @Description: 作为作业
 * @Date: Created in 13:44:10 2019-12-17
 * @Modified By:
 */
public class GPCglibAopProxy implements GPAopProxy{

    public GPCglibAopProxy(GPAdvisedSupport config) {

    }

    @Override
    public Object getProxy() {
        return getProxy();
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return null;
    }
}
