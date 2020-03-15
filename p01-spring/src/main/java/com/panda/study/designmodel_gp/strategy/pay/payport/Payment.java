package com.panda.study.designmodel_gp.strategy.pay.payport;/**
 * Created by My on 2020-03-15.
 */

import com.panda.study.designmodel_gp.strategy.pay.MsgResult;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 13:09:07 2020-03-15
 * @Modified By:
 */
public abstract class Payment {
    public abstract String getName();

    // 通用逻辑放到抽象类里面实现
    public MsgResult pay(String uid, double amount){

        // 余额是否足够
        if (queryBalance(uid) < amount){
            return new MsgResult(500,"支付失败","余额不足");
        }
        return new MsgResult(200,"支付成功","支付金额" + amount);
    }

    protected abstract double queryBalance(String uid);
}
