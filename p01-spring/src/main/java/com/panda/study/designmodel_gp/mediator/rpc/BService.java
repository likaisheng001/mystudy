package com.panda.study.designmodel_gp.mediator.rpc;/**
 * Created by My on 2020-03-22.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:40:57 2020-03-22
 * @Modified By:
 */
public class BService implements IService {
    Registry registry;
    BService(){
        registry.regist("bService",this);
    }
}
