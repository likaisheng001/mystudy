package com.panda.algorithm.common10algorithm;

/**
 * Created by Administrator on 2019/7/20.
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoitower(5,'A','B','C');
    }
    //汉罗塔的移动的方法
    //使用分治算法
    public static void hanoitower(int num,char a,char b,char c){
        //如果只有一个盘
        if (num == 1){
            System.out.println("第1个盘从"+a+"->"+c);
        }else {
            //如果我们有n >= 2情况，我们总是可以看做是两个盘 1.最下边的盘 2.上面的盘
            //1. 先把 最上面的盘 A->B 移动过程会使用到c
            hanoitower(num-1,a,c,b);
            //2. 把最下边的盘 A->C
            System.out.println("第" + num + "个盘从" + a +"->" + c);
            //3. 把B塔的所有盘 从 B->C  移动过程使用到a塔
            hanoitower(num-1,b,a,c);
        }
    }
}
