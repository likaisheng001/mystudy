package com.panda.study.designmodel_gp.mediator.chatroot;/**
 * Created by My on 2020-03-22.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:59:56 2020-03-22
 * @Modified By:
 */
public class User {
    private ChatRoom chatRoom;
    private String name;

    public User(String name,ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String msg){
        chatRoom.showMessage(this,msg);
    }
}
