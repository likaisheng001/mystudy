package com.panda.study.designmodel.strategy.improve;

/**
 * Created by Administrator on 2019/8/7.
 */
public abstract class Duck {
    //属性：策略接口
    FlyBehavior flyBehavior;
    //其它属性 <---> 策略接口
    public Duck() {

    }
    public void quack(){
        System.out.println("鸭子嘎嘎叫 - - - ");
    }
    public void swim(){
        System.out.println("鸭子会游泳 - - - ");
    }
    public void fly(){
        //改进
        if (flyBehavior != null){
            flyBehavior.fly();
        }
    }
    public abstract void display();//显示鸭子的信息

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}
