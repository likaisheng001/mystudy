package com.panda.study.designmodel_gp.decorator.goodhomework02;/**
 * Created by My on 2020-03-10.
 */

import com.google.gson.Gson;

import java.sql.SQLOutput;

/**
 * @Author: Likaisheng
 * @Description:基础导航栏(未登录)
 * @Date: Created in 10:36:31 2020-03-10
 * @Modified By:
 */
public class BasicNavigationBar extends  NavigationBar {

    {
        addFunction(new Function(0L,"问答","/ask"));
        addFunction(new Function(1L,"文章","/article"));
        addFunction(new Function(5L,"精品课","/resources"));
        addFunction(new Function(6L,"冒泡","/bubbling"));
        addFunction(new Function(7L,"商城","/shop"));
    }

    @Override
    public void showNavigation() {
        System.out.println(new Gson().toJson(getFunctions()));
    }
}
