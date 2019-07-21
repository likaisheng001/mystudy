package com.panda.study.java.algorithm.common10algorithm;

import java.util.HashSet;

/**
 * Created by Administrator on 2019/7/21.
 */
public class Test {
    public static void main(String[] args) {
        HashSet<String> hashSet1 = new HashSet<String>();
        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet1.add("1");
        hashSet1.add("2");
        hashSet1.add("100");
        hashSet2.add("1");
        hashSet2.add("2");
        hashSet2.add("200");
        hashSet1.retainAll(hashSet2);
        System.out.println("hashSet=" + hashSet1);
    }
}
