package com.panda.pattern.strategy.promotion;/**
 * Created by My on 2019-12-09.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 21:00:01 2019-12-09
 * @Modified By:
 */
public class CouponStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("领取优惠券，课程的价格直接减去优惠券面值抵扣");
    }
}
