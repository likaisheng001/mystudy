package com.panda.tmptest;/**
 * Created by My on 2019-12-12.
 */

import java.util.TreeSet;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 13:15:09 2019-12-12
 * @Modified By:
 */
public class Demo1 {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        TreeSet<Integer> subSet = new TreeSet<Integer>();
        for (int i = 606; i<613; i++){
            if (i%2==0){
                set.add(i);
            }
        }
        subSet = (TreeSet<Integer>) set.subSet(608,true,611,true);
        set.add(629);
        System.out.println(set+" "+subSet);
    }
}
