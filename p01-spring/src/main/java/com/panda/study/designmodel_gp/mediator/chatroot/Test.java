package com.panda.study.designmodel_gp.mediator.chatroot;/**
 * Created by My on 2020-03-22.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:03:42 2020-03-22
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();
        User tom = new User("Tom",chatRoom);
        User jerry = new User("Jerry",chatRoom);

        tom.sendMessage("Hi! I'm tom");
        jerry.sendMessage("Hello! I'm Jerry");
    }
}
