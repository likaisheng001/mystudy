package com.panda.study.designmodel.factory.factorymethod.order;

import com.panda.study.designmodel.factory.simplefactory.order.SimpleFactory;
import com.panda.study.designmodel.factory.simplefactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2019/7/28.
 */
public abstract class OrderPizza {
    //定义一个抽象方法createPizza,让各个工厂子类自己实现
    abstract Pizza createPizza(String orderType);

    public OrderPizza(){
        Pizza pizza = null;
        String orderType;
        do{
            orderType = getType();
            //抽象方法，由工厂子类完成
            pizza = createPizza(orderType);
            //输出pizza制作过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }while(true);
    }
    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
