package com.panda.study.designmodel_gp.adapter.demo.passport.adapterv2.adapters;/**
 * Created by My on 2020-03-11.
 */

import com.panda.study.designmodel_gp.adapter.demo.passport.ResultMsg;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:12:06 2020-03-11
 * @Modified By:
 */
public interface ILoginAdapter {
    boolean support(Object adapter);
    ResultMsg login(String id,Object adapter);
}
