package com.panda.study.designmodel.factory.abstractfactory.order;

import com.panda.study.designmodel.factory.abstractfactory.pizza.*;

/**
 * Created by Administrator on 2019/7/28.
 */
public class LDFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("使用的是抽象工厂模式- - -");
        Pizza pizza = null;
        if (orderType.equals("chess")){
            pizza = new LDChessPizza();
        }else if (orderType.equals("pepper")){
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
