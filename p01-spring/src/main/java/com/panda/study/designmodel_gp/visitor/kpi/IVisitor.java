package com.panda.study.designmodel_gp.visitor.kpi;/**
 * Created by My on 2020-03-24.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:02:00 2020-03-24
 * @Modified By:
 */
public interface IVisitor {
    void visit(Engineer engineer);
    void visit(Manager manager);
}
