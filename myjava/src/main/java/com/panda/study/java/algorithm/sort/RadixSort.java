package com.panda.study.java.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Administrator on 2019/7/13.
 */
public class RadixSort {
    public static void main(String[] args) {
//        int arr[] = {53,3,542,748,14,214};
//        radixSort(arr);

        //80000000 * 11 * 4 / 1014 / 1024 / 1024 = 3.3G
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int)(Math.random()*8000000); //生成一个[0,8000000)的随机数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是="+dateStr1);
        radixSort(arr);
        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是="+dateStr2);
    }
    //基数排序方法
    public static void radixSort(int[] arr){

        //先得到数组中最大的数的位数
        int max = arr[0]; //假设第一个数就是最大数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();

        //第1轮(针对每个元素的个位进行排序处理)
        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //二维数组包含10个一维数组
        //为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.length
        //基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶中，实际存放了多少个数据，我们定义了一个一维数组来记录各个桶的每次放入的数据个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0,n=1; i < maxLength; i++,n*=10) {
            //针对每个元素的对应位进行排序处理 第一次是个位，第二次是十位，第三次是百位
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的对应位的值
                int digitOfElement = arr[j] /n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index = 0;
            //遍历每一个桶，并将桶中数据，放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0){
                    //循环该桶即i个桶(即第k个一维数组),放入
                    for (int j = 0; j < bucketElementCounts[k]; j++) {
                        arr[index++] = bucket[k][j];
                    }
                }
                //第i+1轮处理后，需要将每个bucketElementCounts[k] = 0 !!!!
                bucketElementCounts[k] = 0;
            }
//            System.out.println("第1轮对个位的排序处理arr=" + Arrays.toString(arr));
        }

        /*
        //第1轮(针对每个元素的个位进行排序处理)
        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //二维数组包含10个一维数组
        //为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.length
        //基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶中，实际存放了多少个数据，我们定义了一个一维数组来记录各个桶的每次放入的数据个数
        int[] bucketElementCounts = new int[10];
        for (int i = 0; i < arr.length; i++) {
            //取出每个元素的个位的值
            int digitOfElement = arr[i] % 10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
        int index = 0;
        //遍历每一个桶，并将桶中数据，放入到原数组
        for (int i = 0; i < bucketElementCounts.length; i++) {
            //如果桶中有数据，我们才放入到原数组
            if (bucketElementCounts[i] != 0){
                //循环该桶即i个桶(即第k个一维数组),放入
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
            //第1轮处理后，需要将每个bucketElementCounts[k] = 0 !!!!
            bucketElementCounts[i] = 0;
        }
        System.out.println("第1轮对个位的排序处理arr=" + Arrays.toString(arr));

        //第2轮(针对每个元素的十位进行排序处理)
        for (int i = 0; i < arr.length; i++) {
            //取出每个元素的个位的值
            int digitOfElement = arr[i] / 10 % 10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
        index = 0;
        //遍历每一个桶，并将桶中数据，放入到原数组
        for (int i = 0; i < bucketElementCounts.length; i++) {
            //如果桶中有数据，我们才放入到原数组
            if (bucketElementCounts[i] != 0){
                //循环该桶即i个桶(即第k个一维数组),放入
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
            bucketElementCounts[i] = 0;
        }
        System.out.println("第2轮对十位的排序处理arr=" + Arrays.toString(arr));

        //第3轮(针对每个元素的百位进行排序处理)
        for (int i = 0; i < arr.length; i++) {
            //取出每个元素的个位的值
            int digitOfElement = arr[i] / 100 % 10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
        index = 0;
        //遍历每一个桶，并将桶中数据，放入到原数组
        for (int i = 0; i < bucketElementCounts.length; i++) {
            //如果桶中有数据，我们才放入到原数组
            if (bucketElementCounts[i] != 0){
                //循环该桶即i个桶(即第k个一维数组),放入
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
        }
        System.out.println("第3轮对百位的排序处理arr=" + Arrays.toString(arr));
        */
    }
}
