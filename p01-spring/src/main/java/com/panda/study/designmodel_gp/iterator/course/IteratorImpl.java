package com.panda.study.designmodel_gp.iterator.course;/**
 * Created by My on 2020-03-16.
 */

import java.util.List;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 20:48:56 2020-03-16
 * @Modified By:
 */
public class IteratorImpl<E> implements Iterator<E> {
    private List<E> list;
    private int cursor;
    private E element;

    public IteratorImpl(List<E> list) {
        this.list = list;
    }

    @Override
    public E next() {
        System.out.println("当前位置：" + cursor + " : ");
        element = list.get(cursor);
        cursor++;
        return element;
    }

    @Override
    public boolean hasNext() {
        if (cursor >= list.size()){
            return false;
        }
        return true;
    }
}
