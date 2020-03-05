package com.panda.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/7/13.
 */
public class MergeSort {
    public static void main(String[] args) {
//        int[] arr = {8,4,5,7,1,3,6,2}; //8->merge 7    80000 -> merge 80000-1
//        int temp[] = new int[arr.length]; //归并排序需要一个额外的空间
//        mergeSort(arr,0,arr.length-1,temp);
//        System.out.println("归并排序后:" + Arrays.toString(arr));

        int[] arr = new int[8000000];
        int[] temp = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int)(Math.random()*8000000); //生成一个[0,8000000)的随机数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是="+dateStr1);
        mergeSort(arr,0,arr.length-1,temp);
        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是="+dateStr2);
    }
    //分的方法
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left<right){
            int mid = (left + right) /2; //中间索引
            //向左递归进行分解
            mergeSort(arr,left,mid,temp);
            //向右递归进行分解
            mergeSort(arr,mid + 1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);
        }
    }

    //合并的方法
    /**
     *
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  做中转的数组
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
//        System.out.println("xxxx");
        int i = left; //初始化i,左边有序序列的初始索引
        int j = mid + 1; //初始化j，右边有序序列的初始索引
        int t = 0; //指向temp数组的当前索引

        //一
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right){
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        //二
        //把有剩余数据的一边的数据依次全部填充到temp
        while (i <= mid){
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right){
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //三
        //将temp数组的元素拷贝到arr
        //注意，并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        //第一次合并tempLeft=0,right=1//tempLeft=2,right=3
        //最后一次tempLeft=0,right=7
//        System.out.println("tempLeft=" + tempLeft + ",right=" + right);
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
