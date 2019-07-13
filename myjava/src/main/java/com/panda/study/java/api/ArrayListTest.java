package com.panda.study.java.api;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by Administrator on 2019/7/11.
 */
public class ArrayListTest {
    public static void fill(ArrayList<Integer> arr){
        for (int i = 1 ; i <= 5 ; i++) {
            arr.add(i);
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList();
        fill(integers);
        ListIterator<Integer> listIterator = integers.listIterator();
        while (listIterator.hasNext()){
            Integer next = listIterator.next();
            if (next % 2 == 0){
                listIterator.add(0);
            }
        }
        System.out.println(integers);
    }
}
