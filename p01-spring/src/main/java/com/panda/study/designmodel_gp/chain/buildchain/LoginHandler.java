package com.panda.study.designmodel_gp.chain.buildchain;/**
 * Created by My on 2020-03-15.
 */

import com.panda.study.designmodel_gp.chain.auth.Member;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:51:55 2020-03-15
 * @Modified By:
 */
public class LoginHandler extends Handler {
    @Override
    public void doHandler(Member member) {
        System.out.println("登录成功! ");
        member.setRoleName("普通用户");
        next.doHandler(member);
    }
}
