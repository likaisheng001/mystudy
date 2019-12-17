package com.panda.spring2.framework.beans;/**
 * Created by My on 2019-12-11.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 20:46:52 2019-12-11
 * @Modified By:
 */
public class GPBeanWrapper {
    private Object wrappedInstance;
    private Class<?> wrappedClass;

    public GPBeanWrapper(Object wrappedInstance) {
        this.wrappedInstance = wrappedInstance;
    }

    //是单例
    public Object getWrappedInstance(){
        return this.wrappedInstance;
    }
    //不是单例
    public Class<?> getWrappedClass(){
        return this.wrappedInstance.getClass();
    }
}
