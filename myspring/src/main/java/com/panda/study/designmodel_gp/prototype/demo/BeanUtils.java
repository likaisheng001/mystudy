package com.panda.study.designmodel_gp.prototype.demo;/**
 * Created by My on 2020-03-01.
 */

import java.lang.reflect.Field;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:28:14 2020-03-01
 * @Modified By:
 */
public class BeanUtils {
    public static Object copy(Object protoType){
        Class clazz = protoType.getClass();
        Object returnVal = null;

        try {
            returnVal = clazz.newInstance();
            for (Field field : clazz.getDeclaredFields()){
                field.setAccessible(true);
                field.set(returnVal,field.get(protoType));
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return returnVal;
    }
}
