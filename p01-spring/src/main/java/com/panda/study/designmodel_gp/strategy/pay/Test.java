package com.panda.study.designmodel_gp.strategy.pay;/**
 * Created by My on 2020-03-15.
 */


/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 13:27:05 2020-03-15
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order("1", "20200314002103213", 324.5);
        System.out.println(order.pay());
    }
}
