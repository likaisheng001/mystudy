package com.panda.study.java.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Administrator on 2019/7/13.
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8,9,1,7,2,3,5,4,6,0};
//        shellSort2(arr);
//        shellSort(arr);

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*8000000); //生成一个[0,8000000)的随机数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是="+dateStr1);
        shellSort2(arr);
        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是="+dateStr2);
    }

    //使用交换来移动元素
    public static void shellSort(int[] arr){
        int temp = 0;
        int count = 0;
        for (int gap = arr.length/2; gap > 0 ; gap /= 2) {
            for (int i = gap ; i < arr.length ; i++) {
                //遍历各组中所有的元素(共gap组，每组有2个元素),步长gap
                for (int j = i - gap; j >= 0; j-=gap) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
//            System.out.println("希尔排序"+(++count)+"轮后="+ Arrays.toString(arr));
        }
        /*
        //使用逐步推导的方式来编写希尔排序
        //思路：分组，排序
        int temp = 0;
        //希尔排序的第1轮排序
        for (int i = 5 ; i < arr.length ; i++) {
            //遍历各组中所有的元素(共5组，每组有2个元素),步长5
            for (int j = i - 5; j >= 0; j-=5) {
                //如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j+5]){
                    temp = arr[j];
                    arr[j] = arr[j+5];
                    arr[j+5] = temp;
                }
            }
        }
        System.out.println("希尔排序1轮后="+ Arrays.toString(arr));
        //希尔排序的第2轮排序
        for (int i = 2 ; i < arr.length ; i++) {
            //遍历各组中所有的元素(共2组，每组有5个元素),步长2
            for (int j = i - 2; j >= 0; j-=2) {
                //如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j+2]){
                    temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2] = temp;
                }
            }
        }
        System.out.println("希尔排序2轮后="+ Arrays.toString(arr));
        //希尔排序的第3轮排序
        for (int i = 1 ; i < arr.length ; i++) {
            //遍历各组中所有的元素(共1组，每组有10个元素),步长1
            for (int j = i - 1; j >= 0; j-=1) {
                //如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("希尔排序3轮后="+ Arrays.toString(arr));
        */
    }
    //使用移动来交换元素
    public static void shellSort2(int[] arr){

        //增量gap，并逐步的缩小增量
        for (int gap = arr.length/2; gap > 0 ; gap /= 2) {
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length ; i++) {
               int j = i;
               int temp = arr[j];
               if (arr[j] < arr[j-gap]){
                   while (j - gap >= 0 && temp < arr[j-gap]){
                       //移动
                       arr[j]=arr[j-gap];
                       j-=gap;
                   }
                   //当退出while后，就给temp找到插入的位置
                   arr[j] = temp;
               }
            }
        }
    }
}
