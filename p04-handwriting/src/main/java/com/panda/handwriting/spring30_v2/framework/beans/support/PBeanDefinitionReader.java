package com.panda.handwriting.spring30_v2.framework.beans.support;/**
 * Created by My on 2020-04-08.
 */

import com.panda.handwriting.spring30_v2.framework.annotation.PController;
import com.panda.handwriting.spring30_v2.framework.annotation.PService;
import com.panda.handwriting.spring30_v2.framework.beans.config.PBeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:52:43 2020-04-08
 * @Modified By:
 */
public class PBeanDefinitionReader {
    private Properties contextConfig = new Properties();
    private List<String> registryBeanClasses = new ArrayList<String>();

    public PBeanDefinitionReader(String... configLocations) {
        doLoadConfig(configLocations[0]);
        //扫描配置文件中配置的相关的类
        doScanner(contextConfig.getProperty("scanPackage"));
    }

    public Properties getConfig(){
        return contextConfig;
    }

    public List<PBeanDefinition> loadBeanDefinitions() {
        List<PBeanDefinition> result = new ArrayList<PBeanDefinition>();
        try {

            for (String className : registryBeanClasses){
                Class<?> beanClass = Class.forName(className);
                // FIXME 此处先简单处理
                if (!(beanClass.isAnnotationPresent(PController.class) || beanClass.isAnnotationPresent(PService.class))){continue;}
                /**
                 * 保存类对应的ClassName(全类名)
                 * 还有beanName
                 * 1. 默认是类名首字母小写
                 * 2. 自定义
                 * 3. 接口注入
                 */
                //1. 默认是类名首字母小写
                String beanName = toLowerFirstCase(beanClass.getSimpleName());
                String beanClassName = beanClass.getName();
                result.add(doCreateBeanDefinition(beanName, beanClassName));
                // TODO 2. 自定义
                // 3. 接口注入
                for (Class<?> i : beanClass.getInterfaces()){
                    result.add(doCreateBeanDefinition(i.getName(),beanClass.getName()));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] +=32;
        return String.valueOf(chars);
    }

    private PBeanDefinition doCreateBeanDefinition(String beanName, String beanClassName) {
        PBeanDefinition beanDefinition = new PBeanDefinition();
        beanDefinition.setFactoryBeanName(beanName);
        beanDefinition.setBeanClassName(beanClassName);
        return beanDefinition;
    }

    private void doLoadConfig(String contextConfigLocation) {
        contextConfigLocation = contextConfigLocation.replace("classpath:","");
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            contextConfig.load(is);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (null != is){
                try {
                    is.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private void doScanner(String scanPackage) {
        //jar、war、zip、rar
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classPath = new File(url.getFile());

        //当成是一个ClassPath文件夹
        for (File file : classPath.listFiles()) {
            if (file.isDirectory()){
                doScanner(scanPackage + "." + file.getName());
            } else {
                if (!file.getName().endsWith(".class")){continue;}
                String className = scanPackage + "." + file.getName().replace(".class", "");
                //Class.forName(className);
                registryBeanClasses.add(className);
            }
        }
    }
}
