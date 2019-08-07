package com.panda.study.designmodel.strategy.improve;

/**
 * Created by Administrator on 2019/8/7.
 */
public class BadFlyBehavior implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("飞翔技术一般");

    }
}
