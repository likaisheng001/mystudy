package com.panda.spring2.framework.beans.support;/**
 * Created by My on 2019-12-10.
 */

import com.panda.spring2.framework.beans.config.GPBeanDefinition;

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
 * @Date: Created in 21:41:05 2019-12-10
 * @Modified By:
 */
public class GPBeanDefinitionReader {
    private List<String> registryBeanClasses = new ArrayList<String>();
    private Properties config = new Properties();
    //固定配置文件中的key，相当于xml的规范
    private final String SCAN_PACKAGE = "scanPackage";

    public GPBeanDefinitionReader(String... locations) {
        //通过URL定位找到其所对应的文件，然后转换为文件流
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(locations[0].replace("classpath:", ""));
        try{
            config.load(is);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        doScanner(config.getProperty(SCAN_PACKAGE));
    }

    private void doScanner(String scanPackage) {
        //com.panda.demo 转换为文件路径
        //此处有个路径的转换问题
        //URL url = this.getClass().getClassLoader().getResource("/"+scanPackage.replaceAll("\\.","/"));
        URL url = this.getClass().getResource("/"+scanPackage.replaceAll("\\.","/"));
        File classPath = new File(url.getFile());
        for (File file : classPath.listFiles()){
            if(file.isDirectory()){
                doScanner(scanPackage+"."+file.getName());
            }else{
                if(!file.getName().endsWith(".class")){
                    continue;
                }
                String className = (scanPackage + "." + file.getName().replace(".class",""));
                registryBeanClasses.add(className);
            }
        }
    }

    public Properties getConfig(){
        return this.config;
    }

    //把配置文件中扫描到的所有的配置信息转换为GPBeanDefinition对象
    public List<GPBeanDefinition> loadBeanDefinitions(){
        List<GPBeanDefinition> result = new ArrayList<GPBeanDefinition>();
        try {
            for (String className : registryBeanClasses){
                Class<?> beanClass = Class.forName(className);
                //如果是一个接口，是不能实例化的，用它实现类来实例化
                if (beanClass.isInterface()){continue;}
                //beanName有三种情况：
                //1. 默认是类名首字母小写
                //2. 自定义名字
                //3. 接口注入
                result.add(doCreateBeanDefinition(toLowerFirstCase(beanClass.getSimpleName()),beanClass.getName()));
                result.add(doCreateBeanDefinition(beanClass.getName(),beanClass.getName()));

                Class<?>[] interfaces = beanClass.getInterfaces();
                for (Class<?> i : interfaces){
                    //如果是多个实现类，只能覆盖
                    //为什么？因为Spring没那么只能，就是这么傻
                    //这个时候，可以自定义名字
                    result.add(doCreateBeanDefinition(i.getName(),beanClass.getName()));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    //把每一个配置信息解析成一个BeanDefinition
    private GPBeanDefinition doCreateBeanDefinition(String factoryName,String className){
        try{
           /* Class<?> beanClass = Class.forName(className);
            //有可能是一个接口,如果是接口，用它的实现类作为beanClassName
            if (beanClass.isInterface()){
                return null;
            }*/
            GPBeanDefinition beanDefinition = new GPBeanDefinition();
            beanDefinition.setBeanClassName(className);
            beanDefinition.setFactoryBeanName(factoryName);
            return beanDefinition;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
