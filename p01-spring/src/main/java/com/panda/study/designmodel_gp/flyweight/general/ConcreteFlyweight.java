package com.panda.study.designmodel_gp.flyweight.general;/**
 * Created by My on 2020-03-10.
 */

import com.panda.study.designmodel_gp.prototype.homework.ConcreteProtoType;

/**
 * @Author: Likaisheng
 * @Description: 具体享元角色
 * @Date: Created in 18:26:40 2020-03-10
 * @Modified By:
 */
public class ConcreteFlyweight implements IFlyweight {
    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState){
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println("Object address: " + System.identityHashCode(this));
        System.out.println("IntrinsicState: " + this.intrinsicState);
        System.out.println("ExtrinsicState: " + extrinsicState);
    }
}
