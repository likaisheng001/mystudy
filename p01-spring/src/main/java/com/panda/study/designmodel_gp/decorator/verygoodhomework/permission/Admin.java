package com.panda.study.designmodel_gp.decorator.verygoodhomework.permission;/**
 * Created by My on 2020-03-10.
 */

import com.panda.study.designmodel_gp.decorator.verygoodhomework.nav.*;

/**
 * @Author: Likaisheng
 * @Description: 管理员: 所有导航
 * @Date: Created in 11:18:15 2020-03-10
 * @Modified By:
 */
public class Admin implements IPermission {
    @Override
    public String showPermNavs() {
        return new UserManageNav(new GrowthWallNav(new QuestionNav(new TaskNav(new CommonNav())))).showNavs();
    }
}
