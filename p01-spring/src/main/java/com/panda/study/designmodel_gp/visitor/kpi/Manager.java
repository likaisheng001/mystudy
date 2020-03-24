package com.panda.study.designmodel_gp.visitor.kpi;/**
 * Created by My on 2020-03-24.
 */

import java.util.Random;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:04:19 2020-03-24
 * @Modified By:
 */
public class Manager extends Employee {
    public Manager(String name) {
        super(name);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    // 考核的是每年新产品的研发数量
    public int getProducts(){
        return new Random().nextInt(10);
    }
}
