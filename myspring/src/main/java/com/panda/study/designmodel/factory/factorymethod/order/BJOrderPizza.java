package com.panda.study.designmodel.factory.factorymethod.order;

import com.panda.study.designmodel.factory.factorymethod.pizza.BJChessPizza;
import com.panda.study.designmodel.factory.factorymethod.pizza.BJPepperPizza;
import com.panda.study.designmodel.factory.simplefactory.pizza.Pizza;

/**
 * Created by Administrator on 2019/7/28.
 */
public class BJOrderPizza extends OrderPizza{
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("chess")){
            pizza = new BJChessPizza();
        }else if (orderType.equals("pepper")){
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
