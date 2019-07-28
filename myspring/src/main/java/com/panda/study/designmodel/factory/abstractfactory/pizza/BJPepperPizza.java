package com.panda.study.designmodel.factory.abstractfactory.pizza;


/**
 * Created by Administrator on 2019/7/27.
 */
public class BJPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京胡椒披萨");
        System.out.println(" 给北京的胡椒披萨准备原材料");
    }
}
