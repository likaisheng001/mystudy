package com.panda.jvm;/**
 * Created by My on 2019-11-23.
 */

/**
 * @Author: Likaisheng
 * @Description: 学习理解栈帧
 * @Date: Created in 09:41:46 2019-11-23
 * @Modified By:
 */
public class StackTest {
    public static void main(String[] args) {
        add(1,2);
        test02();
    }
    public static void add(int a,int b){
        int result = a + b;
    }
    public static void test02(){
        test02();
    }
    public static void test03(){}
}
