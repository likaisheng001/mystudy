package com.panda.study.designmodel_gp.facade.points;/**
 * Created by My on 2020-03-07.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:17:37 2020-03-07
 * @Modified By:
 */
public class ShippingService {
    public String delivery(GiftInfo giftInfo){
        System.out.println(giftInfo.getName() + "进入物流系统");
        String shippingNo = "666";
        return shippingNo;
    }
}
