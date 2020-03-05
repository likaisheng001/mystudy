package com.panda.jvm;/**
 * Created by My on 2019-11-23.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 09:41:46 2019-11-23
 * @Modified By:
 */
public class StackTest {
    private static int num = 0;
    public static void main(String[] args) {
        try{
            StackTest.test1();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("num:" + num);
        }
    }
    public static void test1(){
        num ++;
        test1();
    }
}
