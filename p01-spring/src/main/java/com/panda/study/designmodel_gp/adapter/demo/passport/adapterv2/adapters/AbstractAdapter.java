package com.panda.study.designmodel_gp.adapter.demo.passport.adapterv2.adapters;/**
 * Created by My on 2020-03-11.
 */

import com.panda.study.designmodel_gp.adapter.demo.passport.PassportService;
import com.panda.study.designmodel_gp.adapter.demo.passport.ResultMsg;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:22:00 2020-03-11
 * @Modified By:
 */
public abstract class AbstractAdapter extends PassportService implements ILoginAdapter {
    protected ResultMsg loginForRegist(String username, String password){
        if (null == password){
            password = "THIRD_EMPTY";
        }
        super.regist(username,password);
        return super.login(username,password);
    }
}
