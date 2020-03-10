package com.panda.study.designmodel_gp.decorator.verygoodhomework.permission;/**
 * Created by My on 2020-03-10.
 */

import com.panda.study.designmodel_gp.decorator.verygoodhomework.nav.CommonNav;
import com.panda.study.designmodel_gp.decorator.verygoodhomework.nav.QuestionNav;

/**
 * @Author: Likaisheng
 * @Description: 已登录用户: 基本导航 CommonNav + 题库(QuestionNav)
 * @Date: Created in 11:15:40 2020-03-10
 * @Modified By:
 */
public class LoginUser implements IPermission {
    @Override
    public String showPermNavs() {
        return new QuestionNav(new CommonNav()).showNavs();
    }
}
