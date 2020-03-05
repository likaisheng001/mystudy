package com.panda.study.designmodel.Decorator;

/**
 * Created by Administrator on 2019/7/30.
 */
public class Expresso extends Coffee{
    public Expresso(){
        setDes("expresso");
        setPrice(6.0f);
    }
    @Override
    public float cost() {
        return super.getPrice();
    }
}
