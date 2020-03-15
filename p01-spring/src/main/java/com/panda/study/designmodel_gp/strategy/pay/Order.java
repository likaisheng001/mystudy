package com.panda.study.designmodel_gp.strategy.pay;/**
 * Created by My on 2020-03-15.
 */

import com.panda.study.designmodel_gp.strategy.pay.payport.Payment;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 13:14:26 2020-03-15
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

    public MsgResult pay(){
        return pay(PayStrategy.DEFAULT_PAY);
    }
    public MsgResult pay(String payKey){
        Payment payment = PayStrategy.get(payKey);
        System.out.println("欢迎使用" + payment.getName());
        System.out.println("本次交易金额为" + amount + ",开始扣款");
        return payment.pay(uid, amount);
    }
}
