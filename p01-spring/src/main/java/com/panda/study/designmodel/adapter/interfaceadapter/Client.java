package com.panda.study.designmodel.adapter.interfaceadapter;

/**
 * Created by Administrator on 2019/7/29.
 */
public class Client {
    public static void main(String[] args) {
        AbsAdapter absAdapter = new AbsAdapter(){
            //只需要去覆盖我们需要使用的接口方法
            @Override
            public void m1() {
                System.out.println("使用了m1的方法");
            }
        };
        absAdapter.m1();
    }
}
