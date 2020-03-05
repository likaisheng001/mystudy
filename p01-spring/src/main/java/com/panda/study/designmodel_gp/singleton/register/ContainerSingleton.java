package com.panda.study.designmodel_gp.singleton.register;/**
 * Created by My on 2020-02-27.
 */

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:08:56 2020-02-27
 * @Modified By:
 */
public class ContainerSingleton {
    private ContainerSingleton(){}
    private static Map<String,Object> ioc = new ConcurrentHashMap<String,Object>();
    public static Object getInstance(String className){
        Object instance = null;
        if (!ioc.containsKey(className)){
            try {
                instance = Class.forName(className).newInstance();
                ioc.put(className,instance);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return instance;
        }else {
            return ioc.get(className);
        }
    }
}
