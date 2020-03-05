package com.panda.study.designmodel_gp.singleton.hungry;/**
 * Created by My on 2020-02-27.
 */

/**
 * @Author: Likaisheng
 * @Description: 优点：执行效率高、性能高、没有任何锁
 *                缺点：在某些情况下，可能造成内存浪费
 * @Date: Created in 09:31:32 2020-02-27
 * @Modified By:
 */
public class HungrySingleton {
    private static final HungrySingleton hungrySingleton = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
