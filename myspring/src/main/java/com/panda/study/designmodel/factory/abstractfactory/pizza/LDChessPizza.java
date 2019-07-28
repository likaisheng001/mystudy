package com.panda.study.designmodel.factory.abstractfactory.pizza;


/**
 * Created by Administrator on 2019/7/27.
 */
public class LDChessPizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦奶酪披萨");
        System.out.println(" 给制作奶酪披萨准备原材料 ");
    }
}
