package com.panda.study.designmodel_gp.decorator.goodhomework02;/**
 * Created by My on 2020-03-10.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Likaisheng
 * @Description:抽象导航栏
 * @Date: Created in 10:34:19 2020-03-10
 * @Modified By:
 */
public abstract class NavigationBar {
    private List<Function> functions;

    {
        functions = new ArrayList<>(6);
    }

    protected void addFunction(Function function){
        functions.add(function);
    }

    protected List<Function> getFunctions(){
        return functions;
    }

    public abstract void showNavigation();

}
