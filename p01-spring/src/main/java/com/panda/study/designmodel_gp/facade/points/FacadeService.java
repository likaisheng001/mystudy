package com.panda.study.designmodel_gp.facade.points;/**
 * Created by My on 2020-03-07.
 */

import java.sql.SQLOutput;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:20:46 2020-03-07
 * @Modified By:
 */
public class FacadeService {
    private QualifyService qualifyService = new QualifyService(); // 质检系统
    private PaymentService paymentService = new PaymentService(); // 支付系统
    private ShippingService shippingService = new ShippingService(); // 物流系统

    public void exchange(GiftInfo giftInfo){
        if (qualifyService.isAvailable(giftInfo)){
            if (paymentService.pay(giftInfo)){
                String shippingNo = shippingService.delivery(giftInfo);
                System.out.println("物流系统下单成功,物流单号是: " + shippingNo);
            }
        }
    }
}
