package com.panda.study.designmodel.factory.factorymethod.order;

import com.panda.study.designmodel.factory.factorymethod.pizza.LDChessPizza;
import com.panda.study.designmodel.factory.factorymethod.pizza.LDPepperPizza;
import com.panda.study.designmodel.factory.simplefactory.pizza.Pizza;

/**
 * Created by Administrator on 2019/7/28.
 */
public class LDOrderPizza extends OrderPizza{
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("chess")){
            pizza = new LDChessPizza();
        }else if (orderType.equals("pepper")){
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
