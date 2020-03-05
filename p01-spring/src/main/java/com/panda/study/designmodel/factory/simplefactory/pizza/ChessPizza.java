package com.panda.study.designmodel.factory.simplefactory.pizza;

/**
 * Created by Administrator on 2019/7/27.
 */
public class ChessPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println(" 给制作奶酪披萨准备原材料 ");
    }
}
