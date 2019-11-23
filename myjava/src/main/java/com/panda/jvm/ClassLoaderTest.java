package com.panda.jvm;/**
 * Created by My on 2019-11-23.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 07:42:46 2019-11-23
 * @Modified By:
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println(new ClassLoaderTest().getClass().getClassLoader().getParent().getParent());
        System.out.println(new ClassLoaderTest().getClass().getClassLoader().getParent());
        System.out.println(new ClassLoaderTest().getClass().getClassLoader());
        System.out.println("--------------------------------------------");
        System.out.println(new Object().getClass().getClassLoader());
    }
}
