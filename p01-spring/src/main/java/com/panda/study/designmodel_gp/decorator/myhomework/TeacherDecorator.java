package com.panda.study.designmodel_gp.decorator.myhomework;/**
 * Created by My on 2020-03-07.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:42:42 2020-03-07
 * @Modified By:
 */
public class TeacherDecorator extends NavigationBarDecorator {
    public TeacherDecorator(NavigationBar navigationBar) {
        super(navigationBar);
    }

    @Override
    protected String showMenus() {
        return super.showMenus() + " 批改作业 题库 成长墙 学生管理 班级管理";
    }
}
