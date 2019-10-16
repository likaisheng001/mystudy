package com.panda.algorithm.stack;

import java.util.Arrays;

/**
 * Created by Administrator on 2019/8/14.
 */
public class MiGong {
    public static void main(String[] args) {
        //初始化迷宫
        //其中:0-未走过，1-表示墙，2-表示走过，3-表示死路
        int[][] miGong = new int[8][7];
        initMiGong(miGong);
        show(miGong);
        System.out.println("==================");
        setWay(miGong,1,1);
        show(miGong);
    }
    public static void initMiGong(int[][] miGoing){
        Arrays.fill(miGoing[0],1);
        Arrays.fill(miGoing[7],1);
        for (int i = 1; i < 7 ; i++) {
            miGoing[i][0] = 1;
            miGoing[i][6] = 1;
        }
        miGoing[3][1] = 1;
        miGoing[3][2] = 1;
    }
    public static void show(int[][] miGoing){
        for (int i = 0; i < miGoing.length; i++) {
            for (int j = 0; j < miGoing[0].length; j++) {
                System.out.print(miGoing[i][j]+"\t");
            }
            System.out.println();
        }
    }

    /**
     * 设计递归找路方法：
     * 1.问题分解(递归调用
     * 2.确定不需要求解的最小子问题(出口)
     * @param miGong
     * @param x
     * @param y
     */
    public static boolean setWay(int[][] miGong,int x,int y){
        if(miGong[6][5] == 2){
            return true;
        }else{
            if (miGong[x][y] == 0){
                miGong[x][y] = 2;
                if (setWay(miGong,x-1,y)){
                    return true;
                }else if (setWay(miGong,x,y+1)){
                    return true;
                }else if (setWay(miGong,x+1,y)){
                    return true;
                }else if (setWay(miGong,x,y-1)){
                    return true;
                }else{
                    miGong[x][y] = 3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}
