package com.panda.study.designmodel_gp.strategy.pay.payport;/**
 * Created by My on 2020-03-15.
 */

import com.panda.study.designmodel_gp.strategy.pay.payport.Payment;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 13:06:50 2020-03-15
 * @Modified By:
 */
public class WechatPay extends Payment {

    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 263;
    }
}
