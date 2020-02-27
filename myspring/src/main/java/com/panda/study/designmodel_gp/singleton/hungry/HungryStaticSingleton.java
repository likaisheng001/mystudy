package com.panda.study.designmodel_gp.singleton.hungry;/**
 * Created by My on 2020-02-27.
 */

/**
 * @Author: Likaisheng
 * @Description: JVM加载顺序：先静态后动态，先上后下，先属性后方法。
 * @Date: Created in 09:37:48 2020-02-27
 * @Modified By:
 */
public class HungryStaticSingleton {
    private static final HungryStaticSingleton hungrySingleton;

    static {
        hungrySingleton = new HungryStaticSingleton();
    }

    private HungryStaticSingleton(){}
    public static HungryStaticSingleton getInstance(){
        return hungrySingleton;
    }
}
