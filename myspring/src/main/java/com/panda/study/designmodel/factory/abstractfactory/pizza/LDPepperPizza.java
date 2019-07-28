package com.panda.study.designmodel.factory.abstractfactory.pizza;


/**
 * Created by Administrator on 2019/7/27.
 */
public class LDPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦胡椒披萨");
        System.out.println(" 给胡椒披萨准备原材料");
    }
}
