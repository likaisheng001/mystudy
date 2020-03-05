package com.panda.study.designmodel_gp.singleton.homework;/**
 * Created by My on 2020-02-27.
 */

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Likaisheng
 * @Description: 当多个线程同时调用getInstance()方法，会出现线程安全问题！
 * @Date: Created in 11:08:56 2020-02-27
 * @Modified By:
 */
public class ContainerSingleton {
    private ContainerSingleton(){}
    private static Map<String,Object> ioc = new ConcurrentHashMap<String,Object>();
    public static Object getInstance(String className){
        Object instance = null;

        if (!ioc.containsKey(className)) {
            try {
                Class clazz = Class.forName(className);
                synchronized (clazz){
                    if (!ioc.containsKey(className)){
                        instance = clazz.newInstance();
                        ioc.put(className,instance);
                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return ioc.get(className);
    }
}
