package com.panda.study.designmodel_gp.decorator.verygoodhomework;/**
 * Created by My on 2020-03-10.
 */

import com.panda.study.designmodel_gp.decorator.verygoodhomework.permission.*;


/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:19:18 2020-03-10
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        IPermission notLogInUser = new NotLoginUser();
        System.out.println("未登录用户导航条：");
        System.out.println(notLogInUser.showPermNavs());
        System.out.println("===========================");

        IPermission logInUser = new LoginUser();
        System.out.println("已登录用户导航条：");
        System.out.println(logInUser.showPermNavs());
        System.out.println("===========================");

        IPermission logInVip = new LoginVip();
        System.out.println("已登录会员导航条：");
        System.out.println(logInVip.showPermNavs());
        System.out.println("===========================");

        IPermission admin = new Admin();
        System.out.println("管理员导航条：");
        System.out.println(admin.showPermNavs());
        System.out.println("===========================");
    }
}
