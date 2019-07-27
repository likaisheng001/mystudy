package com.panda.study.designmodel.singleton.type7;


/**
 * Created by Administrator on 2019/7/27.
 */
public class SingletonTest07 {
    public static void main(String[] args) {
        System.out.println("静态内部类 - - - ");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
        System.out.println("instance.hashCode()=" + instance.hashCode() + "instance2.hashCode()=" + instance2.hashCode());
    }
}
//使用静态内部类完成 推荐使用
class Singleton{
    private static volatile Singleton instance;
    private Singleton(){
    }
    //写一个静态内部类，该类中有一个静态属性Singleton
    private static class SingletonInstance{
        private static final Singleton INSTANCE = new Singleton();
    }
    //提供一个静态的公有方法，直接返回SingletonInstance.INSTANCE
    public static Singleton getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
