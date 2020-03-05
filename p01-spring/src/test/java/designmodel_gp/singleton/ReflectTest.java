package designmodel_gp.singleton;/**
 * Created by My on 2020-02-27.
 */

import com.panda.study.designmodel_gp.singleton.lazy.LazyStaticInnerClassSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: Likaisheng
 * @Description: 反射破坏基于静态内部类实现的懒汉式单例
 * @Date: Created in 10:19:15 2020-02-27
 * @Modified By:
 */
public class ReflectTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException {
        try {
            Class<?> clazz = LazyStaticInnerClassSingleton.class;
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object instance = (LazyStaticInnerClassSingleton)constructor.newInstance();
            System.out.println("instance:"+instance);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
