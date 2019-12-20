package com.panda.pattern.strategy.promotion;/**
 * Created by My on 2019-12-09.
 */


import org.apache.commons.lang3.StringUtils;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 21:05:27 2019-12-09
 * @Modified By:
 */
public class PromotionActivityTest {
//    public static void main(String[] args) {
//        PromotionActivity activity618 = new PromotionActivity(new GroupbuyStrategy());
//        PromotionActivity activity1111 = new PromotionActivity(new CashbackStrategy());
//
//        activity618.execute();
//        activity1111.execute();
//    }
//    public static void main(String[] args) {
//        PromotionActivity promotionActivity = null;
//        String promotionKey = "COUPON";
//
//        if (StringUtils.equals(promotionKey,"COUPON")){
//            promotionActivity = new PromotionActivity(new CouponStrategy());
//        }else if (StringUtils.equals(promotionKey,"CASHBACK")){
//            promotionActivity = new PromotionActivity(new CashbackStrategy());
//        } // ...
//
//        promotionActivity.execute();
//    }
    //工厂+单例+策略
    public static void main(String[] args) {
        String promotionKey = "GROUPBUY";
        PromotionActivity promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        promotionActivity.execute();
    }
}
