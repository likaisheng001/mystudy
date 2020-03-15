package com.panda.study.designmodel_gp.chain.auth;/**
 * Created by My on 2020-03-15.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:48:24 2020-03-15
 * @Modified By:
 */
public class Member {
    private String loginName;
    private String loginPass;
    private String roleName;

    public Member(String loginName, String loginPass) {
        this.loginName = loginName;
        this.loginPass = loginPass;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }

    @Override
    public String toString() {
        return "Member{" +
                "loginName='" + loginName + '\'' +
                ", loginPass='" + loginPass + '\'' +
                '}';
    }
}
