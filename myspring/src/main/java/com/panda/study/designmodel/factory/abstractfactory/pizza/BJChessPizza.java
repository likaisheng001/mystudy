package com.panda.study.designmodel.factory.abstractfactory.pizza;


/**
 * Created by Administrator on 2019/7/27.
 */
public class BJChessPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京奶酪披萨");
        System.out.println(" 给北京的奶酪披萨准备原材料 ");
    }
}
