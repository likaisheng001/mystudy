package com.panda.study.designmodel_gp.singleton.lazy;/**
 * Created by My on 2020-02-27.
 */

/**
 * @Author: Likaisheng
 * @Description: 优点：节省了内存,线程安全
 *                缺点：性能低
 * @Date: Created in 09:44:55 2020-02-27
 * @Modified By:
 */
public class LazySimpleSingleton {
    private static LazySimpleSingleton instance;
    private LazySimpleSingleton(){}
    public synchronized static LazySimpleSingleton getInstance(){
        if (instance == null){
            instance = new LazySimpleSingleton();
        }
        return instance;
    }
}
