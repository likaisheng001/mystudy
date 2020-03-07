package com.panda.study.designmodel_gp.decorator.myhomework;/**
 * Created by My on 2020-03-07.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:42:42 2020-03-07
 * @Modified By:
 */
public class StudentDecorator extends NavigationBarDecorator {
    public StudentDecorator(NavigationBar navigationBar) {
        super(navigationBar);
    }

    @Override
    protected String showMenus() {
        return super.showMenus() + " 作业 题库 成长墙";
    }

}
