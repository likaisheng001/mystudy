package com.panda.study.designmodel_gp.mediator.chatroot;/**
 * Created by My on 2020-03-22.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:59:30 2020-03-22
 * @Modified By:
 */
public class ChatRoom {
    public void showMessage(User user,String message){
        System.out.println("["+ user.getName() +"]:" + message);
    }
}
