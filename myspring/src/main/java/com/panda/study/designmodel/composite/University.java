package com.panda.study.designmodel.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/7/31.
 */
//University就是Composite,可以管理College
public class University extends OrganizationComponent{
    List<OrganizationComponent> organizationComponentList = new ArrayList<OrganizationComponent>();

    public University(String name, String des) {
        super(name, des);
    }

    //重写add
    @Override
    protected void add(OrganizationComponent organizationComponent) {
        organizationComponentList.add(organizationComponent);
    }
    //重写
    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponentList.remove(organizationComponent);
    }
    //print方法，就是输出University包含的学院
    @Override
    protected void print() {
        System.out.println("------------"+getName()+"----------");
        //我们遍历list
        for (OrganizationComponent organizationComponent:organizationComponentList) {
            organizationComponent.print();
        }
    }
}
