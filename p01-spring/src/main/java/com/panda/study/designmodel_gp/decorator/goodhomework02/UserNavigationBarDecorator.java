package com.panda.study.designmodel_gp.decorator.goodhomework02;/**
 * Created by My on 2020-03-10.
 */

import com.google.gson.Gson;

import java.util.Collections;
import java.util.List;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 10:42:57 2020-03-10
 * @Modified By:
 */
public class UserNavigationBarDecorator extends NavigationBar {
    private NavigationBar navigationBar;

    public UserNavigationBarDecorator(NavigationBar navigationBar){
        this.navigationBar = navigationBar;
        addFunction(new Function(2L,"作业","/homework"));
        addFunction(new Function(3L,"题库","/question-bank"));
        addFunction(new Function(4L,"成长墙","/growth-wall"));
    }

    @Override
    public void showNavigation() {
        List<Function> toShowList = getFunctions();
        toShowList.addAll(navigationBar.getFunctions());
        Collections.sort(toShowList);
        System.out.println(new Gson().toJson(toShowList));
    }
}
