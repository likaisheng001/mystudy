package com.panda.study.designmodel.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/7/31.
 */
public class College extends OrganizationComponent{
    //这个list中存放的department
    List<OrganizationComponent> organizationComponentList = new ArrayList<OrganizationComponent>();

    public College(String name, String des) {
        super(name, des);
    }

    //重写add
    @Override
    protected void add(OrganizationComponent organizationComponent) {
        //将来实际业务中，Colleage的add和University add不一定完全一样
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
