package com.panda.study.designmodel_gp.singleton.seriable;/**
 * Created by My on 2020-02-27.
 */

import java.io.Serializable;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:21:04 2020-02-27
 * @Modified By:
 */
public class SeriableSingleton implements Serializable {
    // 序列化
    // 把内存中对象的状态转换为字节码的形式
    // 把字节码通过IO输出流，写到磁盘上，永久保存下来，持久化(类似Redis持久化)

    // 反序列化
    // 将持久化的字节码内容，通过IO输入流读到内存中，转化成一个Java对象
    private static final SeriableSingleton INSTANCE = new SeriableSingleton();
    private SeriableSingleton(){}
    public static SeriableSingleton getInstance(){
        return INSTANCE;
    }

    // 桥接模式
    private Object readResolve(){ // 解决序列化和反序列化的对象问题
        return INSTANCE;
    }
}
