package com.panda.spring2.framework.beans.config;

import lombok.Data;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 20:55:27 2019-12-10
 * @Modified By:
 */

@Data
public class GPBeanDefinition {
    private String beanClassName;  //全限定名
    private boolean lazyInit = false;
    private String factoryBeanName; //工厂名，首字母小写
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
