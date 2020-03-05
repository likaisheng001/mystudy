package com.panda.study.designmodel.iterator;

import java.util.Iterator;

/**
 * Created by Administrator on 2019/8/5.
 */
public class ComputerCollege implements College{
    Department[] departments;
    int numOffDepartment = 0;//保存当前数组的对象个数

    public ComputerCollege() {
        departments = new Department[5];
        addDepartment("java专业","java专业");
        addDepartment("php专业","php专业");
        addDepartment("大数据专业","大数据专业");
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        departments[numOffDepartment] = department;
        numOffDepartment += 1;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
