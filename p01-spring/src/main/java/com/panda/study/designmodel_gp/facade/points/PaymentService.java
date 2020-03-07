package com.panda.study.designmodel_gp.facade.points;/**
 * Created by My on 2020-03-07.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:15:42 2020-03-07
 * @Modified By:
 */
public class PaymentService {

    public boolean pay(GiftInfo giftInfo){
        System.out.println("扣减 " + giftInfo.getName() + " 积分成功");
        return true;
    }
}
