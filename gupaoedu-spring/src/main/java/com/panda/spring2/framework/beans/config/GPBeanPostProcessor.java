package com.panda.spring2.framework.beans.config;/**
 * Created by My on 2019-12-14.
 */


/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:43:04 2019-12-14
 * @Modified By:
 */
public class GPBeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }
}
