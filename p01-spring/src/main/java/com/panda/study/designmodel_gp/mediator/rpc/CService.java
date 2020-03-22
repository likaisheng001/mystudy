package com.panda.study.designmodel_gp.mediator.rpc;/**
 * Created by My on 2020-03-22.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:40:57 2020-03-22
 * @Modified By:
 */
public class CService implements IService {
    Registry registry;
    CService(){
        registry.regist("cService",this);
    }
}
