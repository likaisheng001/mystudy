package com.panda.study.designmodel.composite;

/**
 * Created by Administrator on 2019/7/31.
 */
public class Department extends OrganizationComponent{
    //没有集合
    public Department(String name, String des) {
        super(name, des);
    }
    //add,remove就不用写了，因为他是叶子节点
    @Override
    protected void print() {
        System.out.println(getName());
    }
}
