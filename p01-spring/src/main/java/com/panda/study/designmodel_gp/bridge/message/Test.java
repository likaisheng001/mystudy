package com.panda.study.designmodel_gp.bridge.message;/**
 * Created by My on 2020-03-11.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 19:43:29 2020-03-11
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        IMessage message = new SmsMessgae();
        AbstractMessage abstractMessage = new NormalMessage(message);
        abstractMessage.sendMessage("加班申请","王总");

        message = new EmailMessage();
        abstractMessage = new UrgencyMessage(message);
        abstractMessage.sendMessage("加班申请","王总");

    }
}
