package com.panda.spring2.framework.beans;/**
 * Created by My on 2019-12-10.
 */

/**
 * @Author: Likaisheng
 * @Description: 单例工厂的顶层设计
 * @Date: Created in 20:26:41 2019-12-10
 * @Modified By:
 */
public interface GPBeanFactory {
    /**
     * 根据beanName从IOC容器中获得一个实例Bean
     * @param beanName
     * @return
     */
    Object getBean(String beanName) throws Exception;
    Object getBean(Class<?> beanClass) throws Exception;
}
