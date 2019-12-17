package com.panda.spring2.framework.context;


import com.panda.spring2.framework.annotation.GPAutowired;
import com.panda.spring2.framework.annotation.GPController;
import com.panda.spring2.framework.annotation.GPService;
import com.panda.spring2.framework.aop.GPAopProxy;
import com.panda.spring2.framework.aop.GPCglibAopProxy;
import com.panda.spring2.framework.aop.GPJdkDynamicAopProxy;
import com.panda.spring2.framework.aop.config.GPAopConfig;
import com.panda.spring2.framework.aop.support.GPAdvisedSupport;
import com.panda.spring2.framework.beans.GPBeanFactory;
import com.panda.spring2.framework.beans.GPBeanWrapper;
import com.panda.spring2.framework.beans.config.GPBeanDefinition;
import com.panda.spring2.framework.beans.config.GPBeanPostProcessor;
import com.panda.spring2.framework.beans.support.GPBeanDefinitionReader;
import com.panda.spring2.framework.beans.support.GPDefaultListableBeanFactory;


import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 20:33:37 2019-12-10
 * @Modified By:
 */
public class GPApplicationContext extends GPDefaultListableBeanFactory implements GPBeanFactory{
    private String[] configLoactions;
    GPBeanDefinitionReader reader;
    //单例的IOC容器缓存
    private Map<String,Object> singletonObjects = new ConcurrentHashMap<String, Object>();
    //通用的IOC容器
    private Map<String,GPBeanWrapper> factoryBeanInstanceCahche = new ConcurrentHashMap<String, GPBeanWrapper>();

    public GPApplicationContext(String... configLoactions){
        this.configLoactions = configLoactions;
        try {
            refresh();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void refresh() {
        //1. 定位，定位配置文件
        reader = new GPBeanDefinitionReader(configLoactions);
        //2. 加载配置文件，扫描相关的类，把它们封装成BeanDefinition
        List<GPBeanDefinition> beanDefinitions = reader.loadBeanDefinitions();
        //3. 注册，把配置信息放到容器里面(伪IOC容器)
        doRegisterBeanDefinition(beanDefinitions);
        //4. 把不是延时加载的类，提前初始化
        doAutowired();
    }

    //只处理非延时加载的情况
    private void doAutowired() {
        for (Map.Entry<String,GPBeanDefinition> beanDefinitionEntry : super.beanDefinitionMap.entrySet()){
            String beanName = beanDefinitionEntry.getKey();
            if (!beanDefinitionEntry.getValue().isLazyInit()){
                try {
                    getBean(beanName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doRegisterBeanDefinition(List<GPBeanDefinition> beanDefinitions) {
        for (GPBeanDefinition beanDefinition : beanDefinitions){
            super.beanDefinitionMap.put(beanDefinition.getFactoryBeanName(),beanDefinition);
        }
    }
    public Object getBean(Class<?> beanClass) throws Exception{
        return getBean(beanClass.getName());
    }

    //此处分两步的目的，是为了避免循环依赖
    @Override
    public Object getBean(String beanName) throws Exception {
        GPBeanDefinition gpBeanDefinition = this.beanDefinitionMap.get(beanName);

        Object instance = null;
        //这个逻辑还不严谨，自己可以去参考Spring源码
        //工厂模式 + 策略模式
        GPBeanPostProcessor postProcessor = new GPBeanPostProcessor();
        postProcessor.postProcessBeforeInitialization(instance,beanName);

        instance = instantiateBean(beanName,gpBeanDefinition);

        //把这个对象封装到BeanWrapper中
        GPBeanWrapper beanWrapper = new GPBeanWrapper(instance);

        //把BeanWrapper封装到IOC容器中
        //1. 初始化

        //2. 拿到BeanWrapper之后，把BeanWrapper保存到IOC容器中
        this.factoryBeanInstanceCahche.put(beanName,beanWrapper);

        postProcessor.postProcessAfterInitialization(instance,beanName);
        //3. 注入
        populateBean(beanName,gpBeanDefinition,beanWrapper);

        return this.factoryBeanInstanceCahche.get(beanName).getWrappedInstance();
    }

    private void populateBean(String beanName, GPBeanDefinition gpBeanDefinition, GPBeanWrapper gpBeanWrapper) {
        Object instance = gpBeanWrapper.getWrappedInstance();
        //判断只有加了注解的类，才执行依赖注入
//        gpBeanDefinition.getBeanClassName();
        Class<?> clazz = gpBeanWrapper.getWrappedClass();
        //判断只有加了注解的类，才执行依赖注入
        if (!clazz.isAnnotationPresent(GPController.class) || clazz.isAnnotationPresent(GPService.class)){
            return;
        }
        //获得所有的Fields
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            if (!field.isAnnotationPresent(GPAutowired.class)){
                continue;
            }
            GPAutowired autowired = field.getAnnotation(GPAutowired.class);

            String autowiredBeanName = autowired.value().trim();
            if ("".equals(autowiredBeanName)){
                autowiredBeanName = field.getType().getName();
            }
            //强制访问
            field.setAccessible(true);
            try {
                //为什么会为null??
                if (this.factoryBeanInstanceCahche.get(autowiredBeanName) == null){
                    continue;
                }
                field.set(instance,this.factoryBeanInstanceCahche.get(autowiredBeanName).getWrappedInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private Object instantiateBean(String beanName, GPBeanDefinition gpBeanDefinition) {
        //1. 拿到要实例化的对象的类名
        String className = gpBeanDefinition.getBeanClassName();
        //2. 反射实例化，得到一个对象
        Object instance = null;
        try{
            //gpBeanDefinition.getFactoryBeanName();
            //假设默认是单例，细节暂不考虑
            if (this.singletonObjects.containsKey(className)){
                instance = this.singletonObjects.get(className);
            }else{
                Class<?> clazz = Class.forName(className);
                instance = clazz.newInstance();
                GPAdvisedSupport config = instantionAopConfig(gpBeanDefinition);

                config.setTargetClass(clazz);
                config.setTarget(instance);

                //符合PointCut的规则的话，创建代理对象
                if (config.pointCutMatch()){
                    instance = createProxy(config).getProxy();
                }

                this.singletonObjects.put(className,instance);
                this.singletonObjects.put(gpBeanDefinition.getFactoryBeanName(),instance);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return instance;
    }

    private GPAopProxy createProxy(GPAdvisedSupport config) {
        Class<?> targetClass = config.getTargetClass();
        if (targetClass.getInterfaces().length > 0){
            return new GPJdkDynamicAopProxy(config);
        }
        return new GPCglibAopProxy(config);
    }

    private GPAdvisedSupport instantionAopConfig(GPBeanDefinition gpBeanDefinition) {
        GPAopConfig config = new GPAopConfig();
        config.setPointCut(this.reader.getConfig().getProperty("pointCut"));
        config.setAspectClass(this.reader.getConfig().getProperty("aspectClass"));
        config.setAspectBefore(this.reader.getConfig().getProperty("aspectBefore"));
        config.setAspectAfter(this.reader.getConfig().getProperty("aspectAfter"));
        config.setAspectAfterThrow(this.reader.getConfig().getProperty("aspectAfterThrow"));
        config.setAspectAfterThrowingName(this.reader.getConfig().getProperty("aspectAfterThrowingName"));
        return new GPAdvisedSupport(config);
    }

    public String[] getBeanDefinitionNames(){
        return this.beanDefinitionMap.keySet().toArray(new String[this.beanDefinitionMap.size()]);
    }
    public int getBeanDefinitionCount(){
        return this.beanDefinitionMap.size();
    }
    public Properties getConfig(){
        return this.reader.getConfig();
    }
}
