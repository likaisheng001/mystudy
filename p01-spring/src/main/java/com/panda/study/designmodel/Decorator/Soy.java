package com.panda.study.designmodel.Decorator;

/**
 * Created by Administrator on 2019/7/30.
 */
public class Soy extends Decorator{
    public Soy(Drink obj) {
        super(obj);
        setDes("豆浆");
        setPrice(1.5f);
    }
}
