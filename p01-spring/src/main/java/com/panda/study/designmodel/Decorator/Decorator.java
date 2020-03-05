package com.panda.study.designmodel.Decorator;

/**
 * Created by Administrator on 2019/7/30.
 */
public class Decorator extends Drink{
    private Drink obj;

    public Decorator(Drink obj){//组合
        this.obj = obj;
    }
    @Override
    public float cost() {
        //先拿到自己的价格
        return super.getPrice() + obj.cost();
    }

    @Override
    public String getDes() {
        return super.getDes() + " " + super.getPrice()+" && "
                +obj.getDes() + obj.getPrice();
    }
}
