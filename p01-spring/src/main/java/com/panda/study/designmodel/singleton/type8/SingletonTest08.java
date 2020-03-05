package com.panda.study.designmodel.singleton.type8;


/**
 * Created by Administrator on 2019/7/27.
 */
public class SingletonTest08 {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance == instance2);
        System.out.println("instance.hashCode()=" + instance.hashCode() + "instance2.hashCode()=" + instance2.hashCode());
        instance.sayOK();
    }
}
enum Singleton{
    INSTANCE;//属性
    public void sayOK(){
        System.out.println("ok - - - ");
    }
}
