package com.panda.study.designmodel_gp.visitor.kpi;/**
 * Created by My on 2020-03-24.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:09:32 2020-03-24
 * @Modified By:
 */
public class CTOVisitor implements IVisitor {

    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师" + engineer.name + "代码行数:" + engineer.getCodeLines());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("经理：" + manager.name + "产品数量:" + manager.getProducts());
    }
}
