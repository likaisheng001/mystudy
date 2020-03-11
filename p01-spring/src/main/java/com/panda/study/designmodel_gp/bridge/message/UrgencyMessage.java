package com.panda.study.designmodel_gp.bridge.message;/**
 * Created by My on 2020-03-11.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 19:37:16 2020-03-11
 * @Modified By:
 */
public class UrgencyMessage extends AbstractMessage {
    public UrgencyMessage(IMessage message) {
        super(message);
    }

    void sendMessage(String message, String toUser){
        message = "[加急]" + message;
        super.sendMessage(message,toUser);
    }
}
