package com.panda.study.designmodel_gp.proxy.general;/**
 * Created by My on 2020-03-02.
 */


/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 10:53:24 2020-03-02
 * @Modified By:
 */
public class RealSubject implements ISubject {
    @Override
    public void request() {
        System.out.println("我是用户的快递");
    }
}
