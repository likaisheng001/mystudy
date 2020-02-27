package com.panda.study.designmodel_gp.singleton.lazy;/**
 * Created by My on 2020-02-27.
 */

/**
 * @Author: Likaisheng
 * @Description: 优点：利用了Java本身的语法特定，性能高，避免了内存浪费,不能被反射破坏
 *                 缺点：可读性差
 * ClassPath: LazyStaticInnerClassSingleton.class
 *            LazyStaticInnerClassSingleton&LazyHolder.class
 * @Date: Created in 10:11:03 2020-02-27
 * @Modified By:
 */
public class LazyStaticInnerClassSingleton {
    private LazyStaticInnerClassSingleton(){
        if (LazyHolder.INSTCANCE != null){
            throw new RuntimeException("不允许非法访问");
        }
    }
    private static LazyStaticInnerClassSingleton getInstance(){
        return LazyHolder.INSTCANCE;
    }
    private static class LazyHolder{
       private static final LazyStaticInnerClassSingleton INSTCANCE = new LazyStaticInnerClassSingleton();
    }
}
