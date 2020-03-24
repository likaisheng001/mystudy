package com.panda.study.designmodel_gp.visitor.kpi;/**
 * Created by My on 2020-03-24.
 */

import java.util.Random;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:03:23 2020-03-24
 * @Modified By:
 */
public class Engineer extends Employee {

    public Engineer(String name) {
        super(name);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    // 考核指标是每年的代码量
    public int getCodeLines(){
        return new Random().nextInt(100000);
    }
}
