package com.panda.java.aop;

/**
 * Created by Administrator on 2019/6/30.
 */
public interface UserService {
    public void add(User user);

    public void delete(long uuid);

    public void update(long uuid);

    public void getUserInfo(long uuid);

}
