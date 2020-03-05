package designmodel_gp.singleton;/**
 * Created by My on 2020-02-27.
 */

import com.panda.study.designmodel_gp.singleton.register.EnumSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 10:39:58 2020-02-27
 * @Modified By:
 */
public class EnumSingletonTest {
    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.getInstance();
        instance.setData(new Object());
        System.out.println("instance:"+EnumSingleton.getInstance().getData());

//        System.out.println("--------------------------");
//        EnumSingleton instance1 = Enum.valueOf(EnumSingleton.class, "INSTANCE");
//        System.out.println("instance1:"+instance1.getData());

        // Java规定，不能用反射创建枚举
        Class clazz = EnumSingleton.class;
        try {
            Constructor c = clazz.getDeclaredConstructor(String.class,int.class);
            c.setAccessible(true);
            Object instance2 = c.newInstance();
            System.out.println("instance2:" + instance2);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
