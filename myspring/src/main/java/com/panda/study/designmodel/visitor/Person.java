package com.panda.study.designmodel.visitor;

/**
 * Created by Administrator on 2019/8/4.
 */
public abstract class Person {
    //提供一个方法，让访问者可以访问
    public abstract void accept(Action action);
}
