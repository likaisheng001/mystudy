package com.panda.study.designmodel_gp.bridge.message;/**
 * Created by My on 2020-03-11.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 19:33:14 2020-03-11
 * @Modified By:
 */
public interface IMessage {
    // 发送消息的内容和接收人
    void send(String message,String toUser);
}
