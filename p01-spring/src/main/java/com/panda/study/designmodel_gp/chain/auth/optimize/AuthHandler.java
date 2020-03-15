package com.panda.study.designmodel_gp.chain.auth.optimize;/**
 * Created by My on 2020-03-15.
 */

import com.panda.study.designmodel_gp.chain.auth.Member;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:54:01 2020-03-15
 * @Modified By:
 */
public class AuthHandler extends Handler {
    @Override
    public void doHandler(Member member) {
        if (!"管理员".equals(member.getRoleName())){
            System.out.println("您不是管理员，没有操作权限");
            return;
        }
        System.out.println("允许操作");
    }
}
