package com.panda.study.designmodel_gp.bridge.message;/**
 * Created by My on 2020-03-11.
 */

/**
 * @Author: Likaisheng
 * @Description: 这个类是桥接类
 * @Date: Created in 19:38:58 2020-03-11
 * @Modified By:
 */
public abstract class AbstractMessage {
    private IMessage message;

    public AbstractMessage(IMessage message) {
        this.message = message;
    }
    void sendMessage(String message,String toUser){
        this.message.send(message,toUser);
    }
}
