package com.panda.study.designmodel_gp.observer.homework;/**
 * Created by My on 2020-03-25.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:50:11 2020-03-25
 * @Modified By:
 */
public class Question {
    private User user;
    private String content;

    public Question(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Question{" +
                "user=" + user +
                ", content='" + content + '\'' +
                '}';
    }

    public User getUser() {
        return user;
    }
}
