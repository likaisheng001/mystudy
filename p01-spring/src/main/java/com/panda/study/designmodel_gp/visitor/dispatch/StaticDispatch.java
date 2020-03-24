package com.panda.study.designmodel_gp.visitor.dispatch;/**
 * Created by My on 2020-03-24.
 */


/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:31:05 2020-03-24
 * @Modified By:
 */
public class StaticDispatch {
    public void test(String string){
        System.out.println("string:"+string);
    }

    public void test(Integer integer){
        System.out.println("integer:"+integer);
    }

    public static void main(String[] args) {
        String string = "1";
        Integer integer = 1;

        // 静态分派
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.test(integer);
        staticDispatch.test(string);
    }
}
