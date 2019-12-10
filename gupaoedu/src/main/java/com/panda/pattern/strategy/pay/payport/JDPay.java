package com.panda.pattern.strategy.pay.payport;/**
 * Created by My on 2019-12-09.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 21:52:26 2019-12-09
 * @Modified By:
 */
public class JDPay extends Payment {

    @Override
    public String getName() {
        return "京东白条";
    }

    @Override
    protected double queryBalance(String uid) {
        return 500;
    }
}
