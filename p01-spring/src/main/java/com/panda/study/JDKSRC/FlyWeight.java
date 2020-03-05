package com.panda.study.JDKSRC;

/**
 * Created by Administrator on 2019/8/1.
 */
public class FlyWeight {
    public static void main(String[] args) {
        //如果Integer.valueOf(x) x在-128 --- 127,就是使用享元模式返回
        //如果不在范围内,则new

        //小结：
        //1. 在valueOf方法中,先判断值是否在IntegerCache中,如果不在,就创建新的Integer(i)
        //2.valueOf方法,就使用到了享元模式
        //3.如果使用valueOf方法得到一个Integer实例，范围在-128 - 127,执行速度比new块
        Integer x = Integer.valueOf(127);
        Integer y = new Integer(127);
        Integer z = Integer.valueOf(127);
        Integer w = new Integer(127);
        System.out.println(x.equals(y)); // ?
        System.out.println(x == y); // ?
        System.out.println(x == z); // ?
        System.out.println(w == x); // ?
        System.out.println(w == y); // ?

        Integer x1 = Integer.valueOf(200);
        Integer x2 = Integer.valueOf(200);
        System.out.println("x1==x2:" + (x1 == x2));
    }
}