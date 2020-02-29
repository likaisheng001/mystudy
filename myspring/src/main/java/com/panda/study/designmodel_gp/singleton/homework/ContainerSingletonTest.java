package com.panda.study.designmodel_gp.singleton.homework;/**
 * Created by My on 2020-02-29.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:14:44 2020-02-29
 * @Modified By:
 */
public class ContainerSingletonTest {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                Object instance = ContainerSingleton.getInstance(Person.class.getName());
                System.out.println("instance:"+instance);
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                Object instance = ContainerSingleton.getInstance(Person.class.getName());
                System.out.println("instance:"+instance);
            }
        };
        Thread t3 = new Thread() {
            @Override
            public void run() {
                Object instance = ContainerSingleton.getInstance(Object.class.getName());
                System.out.println("instance:"+instance);
            }
        };

        t1.start();
        t2.start();
        t3.start();
    }
}
