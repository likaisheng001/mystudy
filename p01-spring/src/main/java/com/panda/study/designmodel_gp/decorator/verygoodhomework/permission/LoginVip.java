package com.panda.study.designmodel_gp.decorator.verygoodhomework.permission;/**
 * Created by My on 2020-03-10.
 */

import com.panda.study.designmodel_gp.decorator.verygoodhomework.nav.CommonNav;
import com.panda.study.designmodel_gp.decorator.verygoodhomework.nav.GrowthWallNav;
import com.panda.study.designmodel_gp.decorator.verygoodhomework.nav.QuestionNav;
import com.panda.study.designmodel_gp.decorator.verygoodhomework.nav.TaskNav;

/**
 * @Author: Likaisheng
 * @Description: 已登录会员： 基本导航(CommonNav + QuestionNav + TaskNav + GrowthWallNav)
 * @Date: Created in 11:17:02 2020-03-10
 * @Modified By:
 */
public class LoginVip implements IPermission {
    @Override
    public String showPermNavs() {
        return new GrowthWallNav(new QuestionNav(new TaskNav(new CommonNav()))).showNavs();
    }
}
