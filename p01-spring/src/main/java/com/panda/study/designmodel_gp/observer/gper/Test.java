package com.panda.study.designmodel_gp.observer.gper;/**
 * Created by My on 2020-03-24.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:12:41 2020-03-24
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        GPer gper = GPer.getInstance();
        Teacher tom = new Teacher("Tom");
        Teacher jerry = new Teacher("Jerry");
        gper.addObserver(tom);
        gper.addObserver(jerry);

        // 用户行为
        Question question = new Question();
        question.setUserName("张三");
        question.setContent("观察者模式适用于哪些场景？");

        gper.publishQuestion(question);
    }
}
