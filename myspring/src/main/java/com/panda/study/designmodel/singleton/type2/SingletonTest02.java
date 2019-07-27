package com.panda.study.designmodel.singleton.type2;

/**
 * Created by Administrator on 2019/7/27.
 */

public class SingletonTest02 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
        System.out.println("instance.hashCode()=" + instance.hashCode() + "instance2.hashCode()=" + instance2.hashCode());
    }
}

//饿汉式（静态代码块）
class Singleton{
    //1.私有化构造器
    private Singleton(){
    }
    //2.在类内部创建对象实例
    private final static Singleton instance;
    static {
        instance = new Singleton();
    }
    //3.提供一个共有的静态方法，返回实例对象
    public static Singleton getInstance(){
        return instance;
    }
}
