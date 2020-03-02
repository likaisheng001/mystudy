package com.panda.study.designmodel_gp.proxy.general;/**
 * Created by My on 2020-03-02.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 10:52:10 2020-03-02
 * @Modified By:
 */
public class Proxy implements ISubject {
    private ISubject target;

    public Proxy(ISubject target) {
        this.target = target;
    }

    @Override
    public void request() {
        before();
        target.request();
        after();
    }

    private void after() {
        System.out.println("快递已送达，用户已签收");
    }

    private void before() {
        System.out.println("你好用户，有你的快递");
    }
}
