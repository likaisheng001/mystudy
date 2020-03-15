package com.panda.study.designmodel_gp.strategy.promotion;/**
 * Created by My on 2020-03-15.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:57:28 2020-03-15
 * @Modified By:
 */
public class GroupbuyStrategy implements IPromotionStrategy {
    public void doPromotion(){
        System.out.println("5人成团，可以优惠");
    }
}
