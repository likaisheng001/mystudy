package com.panda.study.designmodel.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2019/8/5.
 */
public class InfoColleageIterator implements Iterator{
    //信息工程学院是以List方法存放系
    List<Department> departmentList;
    int index = -1;//索引

    public InfoColleageIterator(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
    //判断list中还有没有下一个元素
    @Override
    public boolean hasNext() {
        if (index >= departmentList.size() -1){
            return false;
        } else {
          index += 1;
          return true;
        }
    }

    @Override
    public Object next() {
        return departmentList.get(index);
    }

    //空实现remove
    @Override
    public void remove() {

    }
}
