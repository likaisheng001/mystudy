package com.panda.study.designmodel_gp.flyweight.general;/**
 * Created by My on 2020-03-10.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Likaisheng
 * @Description: 享元工厂
 * @Date: Created in 18:29:28 2020-03-10
 * @Modified By:
 */
public class FlyweightFactory {
    private static Map<String,IFlyweight> pool = new HashMap<String,IFlyweight>();

    // 因为内部状态具备不变性，因此作为缓存的键
    public static IFlyweight getFlyweight(String intrinsicState){
        if (!pool.containsKey(intrinsicState)){
            IFlyweight flyweight = new ConcreteFlyweight(intrinsicState);
            pool.put(intrinsicState,flyweight);
        }
        return pool.get(intrinsicState);
    }
}
