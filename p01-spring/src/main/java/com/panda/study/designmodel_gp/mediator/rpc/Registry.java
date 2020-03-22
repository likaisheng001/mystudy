package com.panda.study.designmodel_gp.mediator.rpc;/**
 * Created by My on 2020-03-22.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:36:46 2020-03-22
 * @Modified By:
 */
public class Registry {
    // 通过中介者缩短调用链
    // 服务治理
    public boolean regist(String serviceName,IService service){
        return true;
    }

    public IService get(String serviceName){
        return null;
    }
}
