package com.panda.study.designmodel_gp.decorator.verygoodhomework.nav;/**
 * Created by My on 2020-03-10.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:02:30 2020-03-10
 * @Modified By:
 */
public class UserManageNav extends AbsDecorator {
    public UserManageNav(INav nav) {
        super(nav);
    }

    @Override
    public String showNavs() {
        return nav.showNavs() + "--用户管理";
    }
}
