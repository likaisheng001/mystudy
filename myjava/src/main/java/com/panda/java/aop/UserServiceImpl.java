package com.panda.java.aop;

/**
 * Created by Administrator on 2019/6/30.
 */
public class UserServiceImpl implements  UserService {
    public void add(User user){
        System.out.println("add用户成功");
    }
    public void delete(long uuid){
        System.out.println("delete用户成功");
    }
    public void update(long uuid){
        System.out.println("update用户成功");
    }
    public void getUserInfo(long uuid){
        System.out.println("getUserInfo用户成功");
    }
}
