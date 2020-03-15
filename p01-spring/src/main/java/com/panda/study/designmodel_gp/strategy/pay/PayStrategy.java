package com.panda.study.designmodel_gp.strategy.pay;/**
 * Created by My on 2020-03-15.
 */

import com.panda.study.designmodel_gp.strategy.pay.payport.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 13:16:43 2020-03-15
 * @Modified By:
 */
public class PayStrategy {
    public static final String ALi_PAY = "AliPay";
    public static final String JD_PAY = "JdPay";
    public static final String WECHAT_PAY = "WechatPay";
    public static final String UNION_PAY = "UnionPay";
    public static final String DEFAULT_PAY = "AliPay";

    private static Map<String, Payment> strategy = new HashMap<String,Payment>();

    static {
        strategy.put(ALi_PAY,new AliPay());
        strategy.put(JD_PAY,new JDPay());
        strategy.put(WECHAT_PAY,new WechatPay());
        strategy.put(UNION_PAY,new UnionPay());
    }

    public static Payment get(String payKey){
        if (!strategy.containsKey(payKey)){
            return strategy.get(DEFAULT_PAY);
        }
        return strategy.get(payKey);
    }
}
