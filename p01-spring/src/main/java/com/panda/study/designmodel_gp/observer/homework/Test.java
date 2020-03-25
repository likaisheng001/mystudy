package com.panda.study.designmodel_gp.observer.homework;/**
 * Created by My on 2020-03-25.
 */

import com.google.common.eventbus.EventBus;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:54:03 2020-03-25
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        // EventBus是用来分发事件的 - EventBus有点像各事件转发器
        EventBus eventBus = new EventBus();
        User tom = new User("Tom",UserTypeEnum.TEACHER);
        User xiaoMing = new User("小明",UserTypeEnum.STUDENT);
        User liSi = new User("李四",UserTypeEnum.STUDENT);
        eventBus.register(tom);
        eventBus.register(xiaoMing);
        eventBus.register(liSi);

        Question question = new Question(xiaoMing);
        question.setContent("如何成为架构师?");

        eventBus.post(question);
    }
}
