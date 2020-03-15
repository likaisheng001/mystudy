package com.panda.study.designmodel_gp.strategy.promotion;/**
 * Created by My on 2020-03-15.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:54:49 2020-03-15
 * @Modified By:
 */
public class CouponStrategy implements IPromotionStrategy {
    public void doPromotion(){
        System.out.println("使用优惠券抵扣");
    }
}
