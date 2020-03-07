package com.panda.study.designmodel_gp.decorator.goodhomework;/**
 * Created by My on 2020-03-07.
 */

import com.panda.study.designmodel_gp.singleton.threadlocal.ThreadLocalSingleton;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:21:05 2020-03-07
 * @Modified By:
 */
public class LoginManager {
    private static final ThreadLocal<User> sessionUsers = new ThreadLocal<User>();

    /**
     * 登录
     * @param user
     * @return
     */
    public static User login(User user){
        if ("huiyuan".equals(user.getUserName())){
            sessionUsers.set(user);
        }
        return user;
    }

    /**
     * 判断是否已登录
     * @param user
     * @return
     */
    public static boolean isLogin(User user){
        return sessionUsers.get() != null;
    }
}
