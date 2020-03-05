package com.panda.study.designmodel.factory.abstractfactory.order;


/**
 * Created by Administrator on 2019/7/28.
 */
public class PizzaStore {
    public static void main(String[] args) {
//        new OrderPizza(new BJFactory());
        new OrderPizza(new LDFactory());
    }
}
