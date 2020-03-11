package com.panda.study.designmodel_gp.bridge.message;/**
 * Created by My on 2020-03-11.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 19:33:56 2020-03-11
 * @Modified By:
 */
public class SmsMessgae implements IMessage {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用短信消息发送" + message + "给" + toUser);
    }
}
