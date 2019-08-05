package com.panda.study.designmodel.iterator;

import java.util.Iterator;

/**
 * Created by Administrator on 2019/8/5.
 */
public interface College {
    public String getName();
    //增加系的方法
    public void addDepartment(String name,String desc);
    //返回一个迭代器，遍历
    public Iterator createIterator();
}
