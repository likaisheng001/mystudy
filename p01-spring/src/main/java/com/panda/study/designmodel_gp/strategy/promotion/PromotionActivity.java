package com.panda.study.designmodel_gp.strategy.promotion;/**
 * Created by My on 2020-03-15.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 12:01:17 2020-03-15
 * @Modified By:
 */
public class PromotionActivity {
    private IPromotionStrategy strategy;

    public PromotionActivity(IPromotionStrategy strategy){
        this.strategy = strategy;
    }

    public void execute(){
        strategy.doPromotion();
    }
}
