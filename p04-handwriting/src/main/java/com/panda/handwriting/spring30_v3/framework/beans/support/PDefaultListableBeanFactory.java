package com.panda.handwriting.spring30_v3.framework.beans.support;/**
 * Created by My on 2020-04-19.
 */

import com.panda.handwriting.spring30_v3.framework.beans.config.PBeanDefinition;
import com.panda.handwriting.spring30_v3.framework.core.PBeanFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:21:59 2020-04-19
 * @Modified By:
 */
public class PDefaultListableBeanFactory implements PBeanFactory {
    public Map<String, PBeanDefinition> beanDefinitionMap = new HashMap<String, PBeanDefinition>();

    @Override
    public Object getBean(Class beanClass) {
        return null;
    }

    @Override
    public Object getBean(String beanName) {
        return null;
    }

    public void doRegistBeanDefinition(List<PBeanDefinition> beanDefinitions) throws Exception {
        for (PBeanDefinition beanDefinition : beanDefinitions){
            if (this.beanDefinitionMap.containsKey(beanDefinition.getFactoryBeanName())){
                throw new Exception("The " + beanDefinition.getFactoryBeanName() + "is exists");
            }
            beanDefinitionMap.put(beanDefinition.getFactoryBeanName(),beanDefinition);
            beanDefinitionMap.put(beanDefinition.getBeanClassName(),beanDefinition);
        }
    }
}
