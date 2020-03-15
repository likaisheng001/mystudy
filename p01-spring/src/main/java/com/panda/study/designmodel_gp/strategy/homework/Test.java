package com.panda.study.designmodel_gp.strategy.homework;/**
 * Created by My on 2020-03-15.
 */

import com.panda.study.designmodel_gp.builder.sql.Order;

/**
 * @Author: Likaisheng
 * @Description:
 * 1、利用策略模式重构一段业务代码。
 * 模拟一段淘宝上下单后对订单的一系列操作，用户下单后对订单的操作有：查看订单、查看物流、确认收货、延长收货。
 * @Date: Created in 18:40:33 2020-03-15
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        UserOperation userOperation = new UserOperation("20200316123213", "确认收货");
        IOrderOperation orderStartegy = OrderOperationContext.getConcreteOrderStrategy(userOperation);
        orderStartegy.operate();
    }
}
