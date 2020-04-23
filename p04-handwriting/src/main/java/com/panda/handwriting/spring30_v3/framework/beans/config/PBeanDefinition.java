package com.panda.handwriting.spring30_v3.framework.beans.config;/**
 * Created by My on 2020-04-08.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:48:21 2020-04-08
 * @Modified By:
 */
public class PBeanDefinition {
    private String factoryBeanName;
    private String beanClassName;

    public String getFactoryBeanName() {
        return factoryBeanName;
    }

    public void setFactoryBeanName(String factoryBeanName) {
        this.factoryBeanName = factoryBeanName;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }
}
