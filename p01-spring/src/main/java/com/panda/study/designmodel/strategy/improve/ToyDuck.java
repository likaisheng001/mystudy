package com.panda.study.designmodel.strategy.improve;

/**
 * Created by Administrator on 2019/8/7.
 */
public class ToyDuck extends Duck {

    public ToyDuck(){
        flyBehavior = new NoFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("这是玩具鸭");
    }

    //需要重写父类的所有方法
    @Override
    public void quack() {
        System.out.println("玩具鸭不能叫");
    }

    @Override
    public void swim() {
        System.out.println("玩具鸭不会游泳");
    }

}
