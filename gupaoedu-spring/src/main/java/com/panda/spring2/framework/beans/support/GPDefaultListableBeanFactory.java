package com.panda.spring2.framework.beans.support;/**
 * Created by My on 2019-12-10.
 */

import com.panda.spring2.framework.beans.config.GPBeanDefinition;
import com.panda.spring2.framework.context.support.GPAbstractApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 20:49:08 2019-12-10
 * @Modified By:
 */
public class GPDefaultListableBeanFactory extends GPAbstractApplicationContext {
    //存储注册信息的BeanDefinition - 伪IOC容器
    protected final Map<String,GPBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String,GPBeanDefinition>();
}
