package com.panda.study.designmodel_gp.chain.auth.optimize;/**
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
        Handler validateHandler = new ValidateHandler();
        Handler loginHandler = new LoginHandler();
        Handler authHandler = new AuthHandler();

        validateHandler.next(loginHandler);
        loginHandler.next(authHandler);

        validateHandler.doHandler(new Member(loginName,loginPass));
    }
}
