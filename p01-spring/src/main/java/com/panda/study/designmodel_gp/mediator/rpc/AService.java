package com.panda.study.designmodel_gp.mediator.rpc;/**
 * Created by My on 2020-03-22.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:40:46 2020-03-22
 * @Modified By:
 */
public class AService implements IService {
    Registry registry;

    AService() {
        registry.regist("aService", this);
    }
    public void a(){
//        registry.get("bService").xxx();
    }
}
