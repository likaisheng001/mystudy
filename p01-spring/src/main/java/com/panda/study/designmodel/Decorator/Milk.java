package com.panda.study.designmodel.Decorator;

/**
 * Created by Administrator on 2019/7/30.
 */
public class Milk extends Decorator{

    public Milk(Drink obj) {
        super(obj);
        setDes("牛奶");
        setPrice(2.0f);
    }
}
