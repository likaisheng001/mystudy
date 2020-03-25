package com.panda.study.designmodel_gp.observer.homework;/**
 * Created by My on 2020-03-25.
 */

import com.google.common.eventbus.Subscribe;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:52:15 2020-03-25
 * @Modified By:
 */
public class User {
    private String name;
    private UserTypeEnum userType;

    public User(String name, UserTypeEnum userType) {
        this.name = name;
        this.userType = userType;
    }

    @Subscribe
    public void subscribe(Question question){
        if (question.getUser() != this){
            System.out.println(name + userType.getDesc() + "你好!\n" +
                    "\t" + question.getUser().userType.getDesc() + question.getUser().name  + " 刚发布了一个问题:\n" +
                    "\t" + question.getContent());
        }
    }
}
