package com.panda.study.designmodel_gp.strategy.promotion;/**
 * Created by My on 2020-03-15.
 */

import java.util.Set;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:58:55 2020-03-15
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
//        以前的写法
//        String promotion = "";
//        IPromotionStrategy strategy = null;
//        if ("团购".equals(promotion)){
//            strategy = new GroupbuyStrategy();
//        }else if ("".equals(promotion)){
//
//        }
//        strategy.doPromotion();

        //策略模式标准写法
//        String promotion = "";
//        PromotionActivity activity = null;
//        if ("团购".equals(promotion)){
//            activity = new PromotionActivity(new GroupbuyStrategy());
//        }else if ("".equals(promotion)){
//
//        }
//        activity.execute();

        //策略模式 + 工厂模式
        Set<String> promotionKeys = PromotionStrategyFactory.getPromotionKeys();
        String promotionKey = "COUPON";

        IPromotionStrategy promotionStrategy = PromotionStrategyFactory.getPromotionStrategy(promotionKey);
        promotionStrategy.doPromotion();
    }
}
