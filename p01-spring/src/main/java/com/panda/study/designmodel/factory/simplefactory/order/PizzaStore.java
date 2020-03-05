package com.panda.study.designmodel.factory.simplefactory.order;

/**
 * Created by Administrator on 2019/7/27.
 */
public class PizzaStore {
    public static void main(String[] args) {
//        //使用简单工厂模式
//        new OrderPizza(new SimpleFactory());
//        System.out.println("----退出程序----");

          //使用静态工厂创建
        new OrderPizza2();
    }
}
