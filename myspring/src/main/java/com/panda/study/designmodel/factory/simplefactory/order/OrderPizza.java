package com.panda.study.designmodel.factory.simplefactory.order;

import com.panda.study.designmodel.factory.simplefactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2019/7/28.
 */
public class OrderPizza {
    //如果simpleFactory是自己new的-组合，如果simpleFactory是从外面传进来的-聚合
    SimpleFactory simpleFactory;
    Pizza pizza = null;
    String orderType = "";
    public OrderPizza(SimpleFactory simpleFactory){
        this.setFactory(simpleFactory);
    }
    public void setFactory(SimpleFactory simpleFactory){
        String orderType = "";//用户输入的
        this.simpleFactory = simpleFactory;//设置简单工厂对象
        do{
            orderType = getType();
            pizza = simpleFactory.createPizza(orderType);
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
