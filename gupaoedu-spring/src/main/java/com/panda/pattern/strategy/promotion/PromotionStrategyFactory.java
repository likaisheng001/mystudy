package com.panda.pattern.strategy.promotion;/**
 * Created by My on 2019-12-09.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Likaisheng
 * @Description: 注册式单例
 * @Date: Created in 21:25:23 2019-12-09
 * @Modified By:
 */
public class PromotionStrategyFactory {
    private static Map<String,PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<String, PromotionStrategy>();
    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.COUPON,new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.CASHBACK,new CashbackStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.GROUPBUY,new GroupbuyStrategy());
    }
    private static final PromotionStrategy NON_PROMOTION = new EmptyStrategy();
    private  PromotionStrategyFactory(){
    }
    public static PromotionStrategy getPromotionStrategy(String promotionKey){
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return  promotionStrategy == null ? NON_PROMOTION : promotionStrategy;
    }
    private interface PromotionKey{
        String COUPON = "COUPON";
        String CASHBACK = "CASHBACK";
        String GROUPBUY = "GROUPBUY";
    }
}
