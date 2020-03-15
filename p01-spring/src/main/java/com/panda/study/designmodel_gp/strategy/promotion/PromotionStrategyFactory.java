package com.panda.study.designmodel_gp.strategy.promotion;/**
 * Created by My on 2020-03-15.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 12:16:41 2020-03-15
 * @Modified By:
 */
public class PromotionStrategyFactory {
    //策略模式再优化：此处可以将所有的策略信息写入数据库，通过维护数据库，来维护策略工厂，
    //实现代码的更进一步解耦
    private static Map<String,IPromotionStrategy> PROMOTIONS = new HashMap<String,IPromotionStrategy>();

    static {
        PROMOTIONS.put(PromotionKey.COUPON,new CouponStrategy());
        PROMOTIONS.put(PromotionKey.CASHBACK,new CashbackStrategy());
        PROMOTIONS.put(PromotionKey.GROUPBUY,new GroupbuyStrategy());
    }

    private static final IPromotionStrategy EMPTY = new EmptyStrategy();

    private PromotionStrategyFactory(){

    }

    public static IPromotionStrategy getPromotionStrategy(String promotionKey){
        IPromotionStrategy strategy = PROMOTIONS.get(promotionKey);
        return strategy == null ? EMPTY : strategy;
    }

    private interface PromotionKey{
        String COUPON = "COUPON";
        String CASHBACK = "CASKBACK";
        String GROUPBUY = "GROUPBUY";
    }

    public static Set<String> getPromotionKeys(){
        return PROMOTIONS.keySet();
    }
}
