package com.panda.study.designmodel_gp.interpreter.calculate2.calculate;/**
 * Created by My on 2020-03-22.
 */

/**
 * @Author: Likaisheng
 * @Description: 增加()
 * @Date: Created in 19:05:53 2020-03-22
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("result:" + new GPCalculator("100 + ( ) ").calculate());
    }
}
