package com.panda.study.java.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Administrator on 2019/7/10.
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {3,9,-1,10,20};
        //测试冒泡排序的速度O(n^2),给80000个数据，测试
        //创建一个80000个随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*8000000); //生成一个[0,8000000)的随机数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是="+dateStr1);
        bubbleSort(arr);
        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是="+dateStr2);
    }
    public static  void bubbleSort(int[] arr){
        int temp = 0; //临时变量
        boolean flag = false; //标识变量，表示是否进行过交换
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - i -1; j++) {
                if(arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
//            System.out.println("第"+(i+1)+"趟排序后的数组");
//            System.out.println(Arrays.toString(arr));
            if (flag == false){ //在一趟排序中，一次交换都没有发生
                break;
            }else {
                flag = false;
            }
        }
    }
}
