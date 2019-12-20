package com.panda.pattern.strategy.pay;/**
 * Created by My on 2019-12-09.
 */

import com.panda.pattern.strategy.pay.payport.PayStrategy;
import com.panda.pattern.strategy.pay.payport.Payment;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 21:44:15 2019-12-09
 * @Modified By:
 */
public class Order {
    private String uid;
    private String orderId;
    private double amount;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public MsgResult pay(String payKey){
        Payment payment = PayStrategy.get(payKey);
        System.out.println("欢迎使用：" + payment.getName());
        System.out.println("本次交易金额为: " + amount + ",开始扣款...");
        return payment.pay(uid,amount);
    }
}
