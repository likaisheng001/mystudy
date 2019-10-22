package com.panda.java.enum1;/**
 * Created by My on 2019/10/22.
 */

/**
 * @Author: Likaisheng
 * @Description: 演示如何在单例中使用枚举
 * @Date: Created in 17:13 2019/10/22
 * @Modified By:
 */
public class SingleTon2 {
    //私有化构造方法
    private SingleTon2(){};
    private static volatile SingleTon2 singleTon = null;
    public static SingleTon2 getInstance(){
        //第一次校验
        if (singleTon == null){
            synchronized (SingleTon2.class){
                //第二次校验
                if (singleTon == null){
                    singleTon = new SingleTon2();
                }
            }
        }
        return singleTon;
    }
}
enum SingleTon{
    INSTANCE;
}
