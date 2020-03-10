package com.panda.study.designmodel_gp.flyweight.jdk;/**
 * Created by My on 2020-03-10.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 19:10:02 2020-03-10
 * @Modified By:
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "he" + "llo";
        String s4 = "hel" + new String("lo");
        String s5 = new String("hello");
        String s6 = s5.intern();
        String s7 = "h";
        String s8 = "ello";
        String s9 = s7 + s8;

        System.out.println(s1 == s2 ); // true
        System.out.println(s1 == s3);  // true 编译器可以完成字符常量拼接
        System.out.println(s1 == s4);  // false
        System.out.println(s1 == s5);  // false
        System.out.println(s4 == s5);  // false
        System.out.println(s1 == s6);  // true
        System.out.println(s1 == s9);  // false 编译器不能进行变量的拼接(s7/s8是变量)
    }
}
