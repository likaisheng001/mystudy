package com.panda.study.designmodel.factory.factorymethod.order;

/**
 * Created by Administrator on 2019/7/28.
 */
public class PizzaStore {
    public static void main(String[] args) {
//        String loc = "bj";
//        if (loc.equals("bj")){
//            new BJOrderPizza();
//        }else {
//            new LDOrderPizza();
//        }
//        //创建北京口味的各种Pizza
//        new BJOrderPizza();
        //创建伦敦口味的各种Pizza
        new LDOrderPizza();
    }
}
