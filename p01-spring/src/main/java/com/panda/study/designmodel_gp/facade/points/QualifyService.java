package com.panda.study.designmodel_gp.facade.points;/**
 * Created by My on 2020-03-07.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:16:36 2020-03-07
 * @Modified By:
 */
public class QualifyService {

    public boolean isAvailable(GiftInfo giftInfo){
        System.out.println("校验 " + giftInfo.getName() + " 积分通过,库存通过。");
        return true;
    }
}
