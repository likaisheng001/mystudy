package com.panda.study.designmodel_gp.adapter.demo.passport.adapterv2;/**
 * Created by My on 2020-03-11.
 */

import com.panda.study.designmodel_gp.adapter.demo.passport.ResultMsg;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:00:49 2020-03-11
 * @Modified By:
 */
public interface IPassportForThird {
    ResultMsg loginForQQ(String openId);
    ResultMsg loginForWechat(String openId);
    ResultMsg loginForToken(String token);
    ResultMsg loginForTelphone(String phone, String code);
}
