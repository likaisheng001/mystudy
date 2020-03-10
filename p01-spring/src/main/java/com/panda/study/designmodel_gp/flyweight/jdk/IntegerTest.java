package com.panda.study.designmodel_gp.flyweight.jdk;/**
 * Created by My on 2020-03-10.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 19:17:37 2020-03-10
 * @Modified By:
 */
public class IntegerTest {
    public static void main(String[] args) {
        // -128 ~ 127
        Integer a = Integer.valueOf(100);
        Integer b = 100;

        Integer c = Integer.valueOf(1000);
        Integer d = 1000;

        System.out.println(a == b); // true
        System.out.println(c == d); // false
    }
}
