package com.panda.pattern.strategy.pay.payport;/**
 * Created by My on 2019-12-09.
 */

import com.panda.pattern.strategy.pay.MsgResult;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 21:48:53 2019-12-09
 * @Modified By:
 */
public abstract class Payment {
    public abstract String getName();
    protected abstract double queryBalance(String uid);
    public MsgResult pay(String uid,double amount){
        if (queryBalance(uid) < amount){
            return new MsgResult(500,"支付失败","余额不足");
        }
        return new MsgResult(200,"支付成功","支付金额："+ amount);
    }
}
