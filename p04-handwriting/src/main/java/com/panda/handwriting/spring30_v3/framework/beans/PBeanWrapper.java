package com.panda.handwriting.spring30_v3.framework.beans;/**
 * Created by My on 2020-04-08.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:36:45 2020-04-08
 * @Modified By:
 */
public class PBeanWrapper {
    private Object wrapperInstance;
    private Class<?> wrappedClass;

    public PBeanWrapper(Object instance) {
        this.wrapperInstance = instance;
        this.wrappedClass = instance.getClass();
    }

    public Object getWrapperInstance() {
        return wrapperInstance;
    }

    public Class<?> getWrappedClass() {
        return wrappedClass;
    }
}
