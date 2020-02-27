package com.panda.handwriting.spring30.framework.beans;/**
 * Created by My on 2019-12-28.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:34:59 2019-12-28
 * @Modified By:
 */
public class PBeanWrapper {
    private Object wrappedInstance;
    private Class<?> wrappedClass;

    public PBeanWrapper(Object wrappedInstance) {
        this.wrappedInstance = wrappedInstance;
    }

    // 单例
    public Object getWrappedInstance() {
        return wrappedInstance;
    }

    // 非单例
    public Class<?> getWrappedClass() {
        return this.wrappedInstance.getClass();
    }
}
