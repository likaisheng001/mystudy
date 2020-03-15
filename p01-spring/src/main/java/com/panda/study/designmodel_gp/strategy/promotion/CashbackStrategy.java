package com.panda.study.designmodel_gp.strategy.promotion;/**
 * Created by My on 2020-03-15.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:56:22 2020-03-15
 * @Modified By:
 */
public class CashbackStrategy implements IPromotionStrategy {
    public void doPromotion(){
        System.out.println("返现，直接打款到支付宝账号");
    }
}
