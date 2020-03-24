package com.panda.study.designmodel_gp.visitor.kpi;/**
 * Created by My on 2020-03-24.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:19:42 2020-03-24
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        BusinessReport report = new BusinessReport();
        System.out.println("===================CEO看报表=====================");
        report.showReport(new CEOVisitor());
        System.out.println("===================CTO看报表=====================");
        report.showReport(new CTOVisitor());
    }
}
