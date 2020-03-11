package com.panda.study.designmodel_gp.adapter.demo.passport.adapterv2;/**
 * Created by My on 2020-03-11.
 */

import com.panda.study.designmodel_gp.adapter.demo.passport.PassportService;
import com.panda.study.designmodel_gp.adapter.demo.passport.ResultMsg;
import com.panda.study.designmodel_gp.adapter.demo.passport.adapterv2.adapters.*;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:02:25 2020-03-11
 * @Modified By:
 */
public class PassportForThirdAdapter implements IPassportForThird{

    @Override
    public ResultMsg loginForQQ(String openId) {
        return processLogin(openId, LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWechat(String openId) {
        return processLogin(openId, LoginForWechatAdapter.class);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return processLogin(token, LoginForTokenAdapter.class);
    }

    @Override
    public ResultMsg loginForTelphone(String phone, String code) {
        return processLogin(phone, LoginForTelAdapter.class);
    }

    private ResultMsg processLogin(String id,Class<? extends ILoginAdapter> clazz){
        try{
            ILoginAdapter adapter = clazz.newInstance();
            if (adapter.support(adapter)){
                return adapter.login(id,adapter);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
