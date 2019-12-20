package com.panda.pattern.observer.demo1;/**
 * Created by My on 2019-12-11.
 */

import java.util.Observer;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 14:50:58 2019-12-11
 * @Modified By:
 */
public class Teacher implements Observer{
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        Gper gper = (Gper)o;
        Question question = (Question)arg;
        System.out.println("======================");
        System.out.println(name + "老师，你好！\n" + "您收到了一个来自\"" + gper.getName() + "\"的提问，希望您解答，问题内容如下：\n" + question.getContent() + "\n" + "提问者:" + question.getUserName());
    }
}
