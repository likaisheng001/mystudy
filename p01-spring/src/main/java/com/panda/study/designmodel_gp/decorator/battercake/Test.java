package com.panda.study.designmodel_gp.decorator.battercake;/**
 * Created by My on 2020-03-07.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:32:40 2020-03-07
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        Battercake batterCake;
        batterCake = new BaseBattercake();
        batterCake = new EggDecorator(batterCake);
        batterCake = new EggDecorator(batterCake);
        batterCake = new SauageDecorator(batterCake);
        System.out.println(batterCake.getMsg() + "，总价" + batterCake.getPrice());
    }
}
