package com.panda.study.designmodel_gp.visitor.kpi;/**
 * Created by My on 2020-03-24.
 */

import java.util.Random;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:00:09 2020-03-24
 * @Modified By:
 */
public abstract class Employee {
    public String name;
    public int kpi; // 员工KPI

    public Employee(String name) {
        this.name = name;
        kpi = new Random().nextInt(10);
    }

    // 接收访问者访问
    public abstract void accept(IVisitor visitor);
}
