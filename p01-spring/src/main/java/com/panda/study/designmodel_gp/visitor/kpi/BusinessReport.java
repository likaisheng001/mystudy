package com.panda.study.designmodel_gp.visitor.kpi;/**
 * Created by My on 2020-03-24.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:13:29 2020-03-24
 * @Modified By:
 */
public class BusinessReport {
    private List<Employee> employees = new ArrayList<Employee>();

    public BusinessReport() {
        employees.add(new Manager("产品经理A"));
        employees.add(new Engineer("程序员A"));
        employees.add(new Manager("产品经理B"));
        employees.add(new Engineer("程序员B"));
        employees.add(new Manager("产品经理C"));
        employees.add(new Engineer("程序员C"));
    }

    public void showReport(IVisitor visitor){
        for (Employee employee : employees){
            employee.accept(visitor);
        }
    }
}
