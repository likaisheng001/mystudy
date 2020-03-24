package com.panda.study.designmodel_gp.observer.gper;/**
 * Created by My on 2020-03-24.
 */


import java.util.Observable;
import java.util.Observer;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:07:12 2020-03-24
 * @Modified By:
 */
public class Teacher implements Observer {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        GPer gPer = (GPer) o;
        Question question = (Question) arg;
        System.out.println("===========================");
        System.out.println(name + "老师，你好！\n" +
                "你收到了一个来自" + gPer.getName() + "的提问，希望您解答。问题内容如下：\n" +
                question.getContent() + "\n" + "提问者：" + question.getUserName());
    }
}
