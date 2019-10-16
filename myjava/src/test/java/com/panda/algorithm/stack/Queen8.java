package com.panda.algorithm.stack;

/**
 * Created by Administrator on 2019/8/14.
 */
public class Queen8 {
    private static int count = 0;
    public static void main(String[] args) {
        int arr[] = new int[8];//用于表示棋盘
        putQueen(arr,0);
        System.out.println("一共有"+count + "种摆法");
    }
    public static void putQueen(int[] arr,int i){
        if (i == 8){
            print(arr);
            return;
        }
        for (int j = 0; j < 8; j++) {
            arr[i] = j;
            if (check(arr,i)){
                putQueen(arr,i+1);
            }
        }
    }
    public static void print(int[] arr){
        count ++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
    public static boolean check(int[] arr,int i){
        for (int j = 0; j < i; j++) {
            //在同一列和斜线上
            if (arr[j] == arr[i] || Math.abs(i-j) == Math.abs(arr[i]-arr[j])){
                return false;
            }
        }
        return true;
    }
}
