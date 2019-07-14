package com.panda.study.java.algorithm.search;

/**
 * Created by Administrator on 2019/7/14.
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1,9,11,-1,34,89};
        int index = seqSearch(arr,100);
        if (index == -1){
            System.out.println("没有找到");
        }else {
            System.out.println("找到，下标为= " + index);
        }
    }

    /**
     * 这里我们实现的线性查找是找到一个满足条件的值，就返回
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int[] arr,int value){
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]){
                return i;
            }
        }
        return -1;
    }
}
