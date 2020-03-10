package com.panda.study.designmodel_gp.decorator.verygoodhomework.permission;/**
 * Created by My on 2020-03-10.
 */

import com.panda.study.designmodel_gp.decorator.verygoodhomework.nav.CommonNav;

/**
 * @Author: Likaisheng
 * @Description: 未登录用户， 拥有CommonNav
 * @Date: Created in 11:14:53 2020-03-10
 * @Modified By:
 */
public class NotLoginUser implements IPermission {
    @Override
    public String showPermNavs() {
        return new CommonNav().showNavs();
    }
}
