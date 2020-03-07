package com.panda.study.designmodel_gp.decorator.myhomework;/**
 * Created by My on 2020-03-07.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:40:46 2020-03-07
 * @Modified By:
 */
public class NavigationBarDecorator extends NavigationBar {
    private NavigationBar navigationBar;

    public NavigationBarDecorator(NavigationBar navigationBar){
        this.navigationBar = navigationBar;
    }

    @Override
    protected String showMenus() {
        return this.navigationBar.showMenus();
    }
}
