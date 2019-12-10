package com.panda.pattern.strategy.promotion;/**
 * Created by My on 2019-12-09.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 21:03:46 2019-12-09
 * @Modified By:
 */
public class PromotionActivity {
    PromotionStrategy promotionStrategy;
    public PromotionActivity(PromotionStrategy promotionStrategy){
        this.promotionStrategy = promotionStrategy;
    }

    public void execute(){
        this.promotionStrategy.doPromotion();
    }
}
