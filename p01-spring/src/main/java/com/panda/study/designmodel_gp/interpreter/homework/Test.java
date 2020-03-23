package com.panda.study.designmodel_gp.interpreter.homework;/**
 * Created by My on 2020-03-23.
 */

import java.lang.reflect.Field;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:08:16 2020-03-23
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("result: " + new GPCalculator("10 + 30").calculate());
        System.out.println("result: " + new GPCalculator("10 + 30 - 20").calculate());
        System.out.println("result: " + new GPCalculator("100 * 2 + 400 * 1 + 66").calculate());

        System.out.println("result: " + new GPAdvancedCalculator("10 + 30 / ( ( 6 - 4 ) * 2 - 2 )").calculate());
    }
}
