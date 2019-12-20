package com.panda.pattern.strategy.pay.payport;/**
 * Created by My on 2019-12-09.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 21:57:09 2019-12-09
 * @Modified By:
 */
public class PayStrategy {
    public static final String ALI_PAY = "Alipay";
    public static final String JD_PAY = "Jdpay";
    public static final String WECHAT_PAY = "Wechatpay";
    public static final String UNION_PAY = "Unionpay";
    public static final String DEFAULT_PAY = ALI_PAY;

    private static Map<String,Payment> payStrategy = new HashMap<String,Payment>();
    static {
        payStrategy.put(ALI_PAY,new AliPay());
        payStrategy.put(JD_PAY,new JDPay());
        payStrategy.put(WECHAT_PAY,new WechatPay());
        payStrategy.put(UNION_PAY,new UnionPay());
    }
    //通过统一入口实现动态策略
    public static Payment get(String paykey){
        if (!payStrategy.containsKey(paykey)){
            return payStrategy.get(DEFAULT_PAY);
        }
        return payStrategy.get(paykey);
    }
}
