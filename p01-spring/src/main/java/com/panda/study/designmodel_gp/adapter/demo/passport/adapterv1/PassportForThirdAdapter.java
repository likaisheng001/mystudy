package com.panda.study.designmodel_gp.adapter.demo.passport.adapterv1;/**
 * Created by My on 2020-03-11.
 */

import com.panda.study.designmodel_gp.adapter.demo.passport.PassportService;
import com.panda.study.designmodel_gp.adapter.demo.passport.ResultMsg;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:02:25 2020-03-11
 * @Modified By:
 */
public class PassportForThirdAdapter extends PassportService implements IPassportForThird{

    @Override
    public ResultMsg loginForQQ(String openId) {
        return loginForRegist(openId,null);
    }

    @Override
    public ResultMsg loginForWechat(String openId) {
        return loginForRegist(openId,null);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return loginForRegist(token,null);
    }

    @Override
    public ResultMsg loginForTelphone(String phone, String code) {
        return loginForRegist(phone,null);
    }

    private ResultMsg loginForRegist(String username,String password){
        if (null == password){
            password = "THIRD_EMPTY";
        }
        super.regist(username,password);
        return super.login(username,password);
    }
}
