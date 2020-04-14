package com.panda.handwriting.spring30_v2.framework.context;/**
 * Created by My on 2020-04-08.
 */

import com.panda.handwriting.spring30_v2.framework.annotation.PAutowired;
import com.panda.handwriting.spring30_v2.framework.annotation.PController;
import com.panda.handwriting.spring30_v2.framework.annotation.PService;
import com.panda.handwriting.spring30_v2.framework.aop.PJdkDynamicAopProxy;
import com.panda.handwriting.spring30_v2.framework.aop.config.PAopConfig;
import com.panda.handwriting.spring30_v2.framework.aop.support.PAdvicedSupport;
import com.panda.handwriting.spring30_v2.framework.beans.PBeanWrapper;
import com.panda.handwriting.spring30_v2.framework.beans.config.PBeanDefinition;
import com.panda.handwriting.spring30_v2.framework.beans.support.PBeanDefinitionReader;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: Likaisheng
 * @Description: GPApplicationContext职责是，完成Bean的创建和DI。
 * @Date: Created in 16:40:53 2020-04-08
 * @Modified By:
 */
public class PApplicationContext {

    private PBeanDefinitionReader reader;
    private Map<String, PBeanDefinition> beanDefinitionMap = new HashMap<String, PBeanDefinition>();
    private Map<String, PBeanWrapper> factoryBeanInstanceCache = new HashMap<String, PBeanWrapper>();
    private Map<String,Object> factoryBeanObjectCache = new HashMap<String,Object>();

    public PApplicationContext(String... configLocations){
        try {
            //1. 加载配置文件
            reader = new PBeanDefinitionReader(configLocations);
            //2. 解析配置文件，封装成BeanDefinition
            List<PBeanDefinition> beanDefinitionList = reader.loadBeanDefinitions();
            //3. 把BeanDefinition缓存起来
            doRegistBeanDefinition(beanDefinitionList);
            //4. 自动注入
            doAutowrited();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void doAutowrited() {
        // 调用getBean();
        // 这一步，所有的Bean并没有真正的实例化，还只是配置阶段
        for (Map.Entry<String, PBeanDefinition> beanDefinitionEntry : this.beanDefinitionMap.entrySet()){
            String beanName = beanDefinitionEntry.getKey();
            getBean(beanName);
        }
    }

    private void doRegistBeanDefinition(List<PBeanDefinition> beanDefinitions) throws Exception {
        for (PBeanDefinition beanDefinition : beanDefinitions){
            if (this.beanDefinitionMap.containsKey(beanDefinition.getFactoryBeanName())){
                throw new Exception("The " + beanDefinition.getFactoryBeanName() + "is exists");
            }
            beanDefinitionMap.put(beanDefinition.getFactoryBeanName(),beanDefinition);
            beanDefinitionMap.put(beanDefinition.getBeanClassName(),beanDefinition);
        }
    }

    // Bean的实例化，DI是从这个方法开始的
    public Object getBean(String beanName){
        //TODO 此处应该有点问题，bean可能重复
        //1. 先拿到配置信息BeanDefinition
        PBeanDefinition beanDefinition = this.beanDefinitionMap.get(beanName);
        //2. 反射实例化newInstance();
        Object instance = instantiateBean(beanName,beanDefinition);
        //3. 封装成一个叫做BeanWrapper
        PBeanWrapper beanWrapper = new PBeanWrapper(instance);
        //4. 保存到IoC容器
        factoryBeanInstanceCache.put(beanName,beanWrapper);
        //5. 执行依赖注入
        populateBean(beanName,beanDefinition,beanWrapper);
        return beanWrapper.getWrapperInstance();
    }

    private void populateBean(String beanName, PBeanDefinition beanDefinition, PBeanWrapper beanWrapper) {
        // 可能会涉及到循环依赖
        // 用两个缓存，循环两次
        // 1.把第一次读取结果为空的BeanDefinition存到第一个缓存
        // 2.等第一次循环之后，第二次循环再检查第一次的缓存，再进行赋值

        Object instance = beanWrapper.getWrapperInstance();
        Class<?> clazz = beanWrapper.getWrappedClass();

        if (!(clazz.isAnnotationPresent(PController.class) || clazz.isAnnotationPresent(PService.class))){
            return;
        }

        for (Field field : clazz.getDeclaredFields()){
            if (!field.isAnnotationPresent(PAutowired.class)){continue;}
            PAutowired autowired = field.getAnnotation(PAutowired.class);
            String autowiredBeanName = autowired.value().trim();
            if ("".equals(autowiredBeanName)){
                autowiredBeanName = field.getType().getName();
            }
            field.setAccessible(true);

            try {
                if (this.factoryBeanInstanceCache.get(autowiredBeanName) == null){continue;}
                field.set(instance,this.factoryBeanInstanceCache.get(autowiredBeanName).getWrapperInstance());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    // 创建真正的实例对象
    private Object instantiateBean(String beanName, PBeanDefinition beanDefinition) {
        String className = beanDefinition.getBeanClassName();
        Object instance = null;
        try {
            if (factoryBeanObjectCache.containsKey(beanName)){
                instance = factoryBeanObjectCache.get(beanName);
            } else {
                Class<?> clazz = Class.forName(className);
                instance = clazz.newInstance();

                //=================== AOP开始 ===========================
                //如果满足条件，就直接返回Proxy对象
                //1. 加载AOP的配置文件
                //FIXME AopConfig可以外提，避免每次创建
                PAdvicedSupport config = instantionAopConfig();
                config.setTargetClass(clazz);
                config.setTarget(instance);
                //判断规则，要不要生成代理类，如果要就覆盖原生对象
                //如果不要就不做任何处理，返回原生对象
                if (config.pointCutMatch()){
                    instance = new PJdkDynamicAopProxy(config).getProxy();
                }
                //=================== AOP结束 ===========================

                this.factoryBeanObjectCache.put(beanName,instance);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return instance;
    }

    private PAdvicedSupport instantionAopConfig() {
        PAopConfig config = new PAopConfig();
        config.setPointCut(this.reader.getConfig().getProperty("pointCut"));
        config.setAspectClass(this.reader.getConfig().getProperty("aspectClass"));
        config.setAspectBefore(this.reader.getConfig().getProperty("aspectBefore"));
        config.setAspectAfter(this.reader.getConfig().getProperty("aspectAfter"));
        config.setAspectAfterThrow(this.reader.getConfig().getProperty("aspectAfterThrow"));
        config.setAspectAfterThrowingName(this.reader.getConfig().getProperty("aspectAfterThrowingName"));
        return new PAdvicedSupport(config);
    }

    public Object getBean(Class beanClass){
        return getBean(beanClass.getName());
    }

    public int getBeanDefinitionCount() {
        return this.beanDefinitionMap.size();
    }

    public String[] getBeanDefinitionNames() {
        return this.beanDefinitionMap.keySet().toArray(new String[this.beanDefinitionMap.size()]);
    }

    public Properties getConfig() {
        return this.reader.getConfig();
    }
}
