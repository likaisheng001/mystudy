package com.panda.study.designmodel_gp.strategy.homework;/**
 * Created by My on 2020-03-15.
 */

/**
 * @Author: Likaisheng
 * @Description: 查看订单
 * @Date: Created in 18:20:39 2020-03-15
 * @Modified By:
 */
public class SeeOrder implements IOrderOperation{
    @Override
    public void operate() {
        System.out.println("用户查看订单");
    }
}
