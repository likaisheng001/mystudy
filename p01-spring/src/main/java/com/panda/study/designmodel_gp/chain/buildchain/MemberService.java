package com.panda.study.designmodel_gp.chain.buildchain;/**
 * Created by My on 2020-03-15.
 */

import com.panda.study.designmodel_gp.chain.auth.Member;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:55:27 2020-03-15
 * @Modified By:
 */
public class MemberService {
    public void login(String loginName,String loginPass){
        Handler.Builder builder = new Handler.Builder();
        builder.addHandler(new ValidateHandler());
        builder.addHandler(new LoginHandler());
        builder.addHandler(new AuthHandler());
        builder.build().doHandler(new Member(loginName,loginPass));
        // 用过Netty的人，肯定见过
    }
}
