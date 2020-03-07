package com.panda.study.designmodel_gp.decorator.myhomework;/**
 * Created by My on 2020-03-07.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:44:54 2020-03-07
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        NavigationBar navigationBar;
        navigationBar = new BaseNavigationBar();
        navigationBar = new StudentDecorator(navigationBar);
        navigationBar = new TeacherDecorator(navigationBar);

        System.out.println(navigationBar.showMenus());
    }
}
