package com.panda.pattern.strategy.promotion;/**
 * Created by My on 2019-12-09.
 */

/**
 * @Author: Likaisheng
 * @Description: 无优惠
 * @Date: Created in 20:57:43 2019-12-09
 * @Modified By:
 */
public class EmptyStrategy implements PromotionStrategy{
    public void doPromotion(){
        System.out.println("无促销活动");
    }
}
