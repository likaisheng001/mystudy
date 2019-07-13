package com.panda.study.java.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Date;
public class InsertSort {
    public static void main(String[] args) {
//         int[] arr = {101,34,119,1};
//        int[] arr = {101,34,119,1,-1,89};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*8000000); //生成一个[0,8000000)的随机数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是="+dateStr1);
        insertSort(arr);
        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是="+dateStr2);
    }
    //插入排序 思路：确定数，[找位置，后移]，插入
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            //插入排序的优化
            if (insertIndex + 1 != i){
                arr[insertIndex+1]=insertVal;
            }
        }
    }
}
