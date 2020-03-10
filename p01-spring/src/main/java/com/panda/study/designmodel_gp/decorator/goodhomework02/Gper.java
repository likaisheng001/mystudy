package com.panda.study.designmodel_gp.decorator.goodhomework02;/**
 * Created by My on 2020-03-10.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 10:46:07 2020-03-10
 * @Modified By:
 */
public class Gper {
    public static void main(String[] args) {
        NavigationBar basicBar = new BasicNavigationBar();
        NavigationBar userBar  = new UserNavigationBarDecorator(basicBar);
        userBar.showNavigation();
        basicBar.showNavigation();
    }
}
