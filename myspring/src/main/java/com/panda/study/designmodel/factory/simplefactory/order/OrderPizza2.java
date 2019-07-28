package com.panda.study.designmodel.factory.simplefactory.order;

import com.panda.study.designmodel.factory.simplefactory.pizza.ChessPizza;
import com.panda.study.designmodel.factory.simplefactory.pizza.GreekPizza;
import com.panda.study.designmodel.factory.simplefactory.pizza.PepperPizza;
import com.panda.study.designmodel.factory.simplefactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2019/7/27.
 */
//Pizza订单
public class OrderPizza2 {
    Pizza pizza = null;
    String orderType = "";
    public OrderPizza2(){
        do{
            orderType = gettype();
            pizza = SimpleFactory.createPizza2(orderType);
            //输出pizza
            if (pizza != null){//订购成功
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println(" 订购披萨失败");
                break;
            }
        }while (true);
    }

    //写一个方法，可以获取客户希望订购的披萨种类
    private String gettype() {
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
