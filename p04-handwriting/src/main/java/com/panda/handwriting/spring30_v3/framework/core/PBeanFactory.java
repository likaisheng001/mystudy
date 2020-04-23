package com.panda.handwriting.spring30_v3.framework.core;/**
 * Created by My on 2020-04-19.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:22:34 2020-04-19
 * @Modified By:
 */
public interface PBeanFactory {
    Object getBean(Class beanClass);
    Object getBean(String beanName);
}
