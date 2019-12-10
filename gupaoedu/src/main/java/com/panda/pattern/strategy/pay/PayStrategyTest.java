package com.panda.pattern.strategy.pay;/**
 * Created by My on 2019-12-09.
 */

import com.panda.pattern.delegate.mvc.controller.OrderController;
import com.panda.pattern.strategy.pay.payport.PayStrategy;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 21:55:19 2019-12-09
 * @Modified By:
 */
public class PayStrategyTest {
    public static void main(String[] args) {
        Order order = new Order("1","2019120900000001",324.5);
        MsgResult result = order.pay(PayStrategy.ALI_PAY);
        System.out.println(result);
    }
}
