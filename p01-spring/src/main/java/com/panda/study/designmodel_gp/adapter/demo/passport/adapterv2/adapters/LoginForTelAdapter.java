package com.panda.study.designmodel_gp.adapter.demo.passport.adapterv2.adapters;/**
 * Created by My on 2020-03-11.
 */

import com.panda.study.designmodel_gp.adapter.demo.passport.PassportService;
import com.panda.study.designmodel_gp.adapter.demo.passport.ResultMsg;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:15:28 2020-03-11
 * @Modified By:
 */
public class LoginForTelAdapter extends AbstractAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTelAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return super.loginForRegist(id,null);
    }

}
