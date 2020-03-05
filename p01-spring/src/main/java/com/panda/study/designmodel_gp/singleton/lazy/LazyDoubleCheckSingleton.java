package com.panda.study.designmodel_gp.singleton.lazy;/**
 * Created by My on 2020-02-27.
 */

/**
 * @Author: Likaisheng
 * @Description: 优点：性能提高了，线程安全了
 *                缺点：可读性差，不够优雅
 * @Date: Created in 10:03:28 2020-02-27
 * @Modified By:
 */
public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton instance;
    private LazyDoubleCheckSingleton(){}
    public static LazyDoubleCheckSingleton getInstance(){
        if (instance == null){
            synchronized (LazyDoubleCheckSingleton.class){
                if (instance == null){
                    instance = new LazyDoubleCheckSingleton();
                    // 此处存在指令重排序的问题 volatile
                }
            }
        }
        return instance;
    }
}
