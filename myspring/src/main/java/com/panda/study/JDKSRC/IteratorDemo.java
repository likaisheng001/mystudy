package com.panda.study.JDKSRC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2019/8/5.
 */
public class IteratorDemo {
    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        a.add("jack");
        //获取到迭代器
        Iterator Itr = a.iterator();
        while (Itr.hasNext()){
            System.out.println(Itr.next());;
        }
    }
}
