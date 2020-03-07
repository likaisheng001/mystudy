package com.panda.study.designmodel_gp.decorator.myhomework;/**
 * Created by My on 2020-03-07.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:35:42 2020-03-07
 * @Modified By:
 */
public class BaseNavigationBar extends NavigationBar {

    @Override
    protected String showMenus() {
        return "问答 文章 精品课 冒泡 商城";
    }
}
