package com.panda.study.designmodel.factory.abstractfactory.order;

import com.panda.study.designmodel.factory.abstractfactory.pizza.BJChessPizza;
import com.panda.study.designmodel.factory.abstractfactory.pizza.BJPepperPizza;
import com.panda.study.designmodel.factory.abstractfactory.pizza.Pizza;

//这是工厂子类
public class BJFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("使用的是抽象工厂模式- - -");
        Pizza pizza = null;
        if (orderType.equals("chess")){
            pizza = new BJChessPizza();
        }else if (orderType.equals("pepper")){
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
