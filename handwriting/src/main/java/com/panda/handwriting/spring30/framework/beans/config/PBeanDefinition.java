package com.panda.handwriting.spring30.framework.beans.config;/**
 * Created by My on 2019-12-28.
 */

import lombok.Data;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:24:45 2019-12-28
 * @Modified By:
 */
public class PBeanDefinition {
    private String beanClassName;// 全限定名
    private boolean lazyInit = false;
    private String factoryBeanName; // 工厂名，首字母小写
    private boolean isSingleton = true;

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    public String getFactoryBeanName() {
        return factoryBeanName;
    }

    public void setFactoryBeanName(String factoryBeanName) {
        this.factoryBeanName = factoryBeanName;
    }

    public boolean isSingleton() {
        return isSingleton;
    }

    public void setSingleton(boolean singleton) {
        isSingleton = singleton;
    }
}

