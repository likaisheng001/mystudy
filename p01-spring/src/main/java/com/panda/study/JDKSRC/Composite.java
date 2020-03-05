package com.panda.study.JDKSRC;

import java.util.HashMap;

/**
 * Created by Administrator on 2019/7/31.
 */
public class Composite {
    public static void main(String[] args) {
        //说明
        //1.Map就是一个抽象的构建(类似我们的Component)
        //2.HashMap是一个中间的构建(Composite),实现了相关方法
        //put(),putAll()
        //3.Node 是 HashMap的静态内部类，类似Leaf叶子节点，这里就没有put,putAll方法
        HashMap<Integer, String> hashMap = new HashMap<>();
        //直接存放叶子节点(Node)
        hashMap.put(0,"东游记");
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"西游记");
        map.put(2,"红楼梦");
        hashMap.putAll(map);
        System.out.println(hashMap);
    }
}
