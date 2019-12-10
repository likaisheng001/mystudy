package com.panda.pattern.strategy.pay.payport;/**
 * Created by My on 2019-12-09.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 21:51:55 2019-12-09
 * @Modified By:
 */
public class AliPay extends Payment{
    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    protected double queryBalance(String uid) {
        return 900;
    }
}
