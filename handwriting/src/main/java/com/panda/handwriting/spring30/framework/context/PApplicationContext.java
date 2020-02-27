package com.panda.handwriting.spring30.framework.context;/**
 * Created by My on 2019-12-28.
 */

import com.panda.handwriting.spring30.framework.beans.PBeanWrapper;
import com.panda.handwriting.spring30.framework.beans.support.PBeanDefinitionReader;
import com.panda.handwriting.spring30.framework.context.support.PAbstractApplicationContext;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:18:34 2019-12-28
 * @Modified By:
 */
public class PApplicationContext extends PAbstractApplicationContext {
    private String[] configLocations;
    PBeanDefinitionReader reader;
    // 单例的IOC容器缓存
    private Map<String,Object> singletonObjects = new ConcurrentHashMap<String,Object>();
    private Map<String, PBeanWrapper> factoryBeanInstanceCache = new ConcurrentHashMap<String, PBeanWrapper>();

    public PApplicationContext(String... configLocations) {
        this.configLocations = configLocations;
        try {
            refresh();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void refresh() {
        // 1.定位
        reader = new PBeanDefinitionReader(configLocations);
    }
}
