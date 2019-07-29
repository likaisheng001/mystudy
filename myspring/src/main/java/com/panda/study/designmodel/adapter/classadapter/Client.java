package com.panda.study.designmodel.adapter.classadapter;

/**
 * Created by Administrator on 2019/7/29.
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("=====类适配器模式========");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
