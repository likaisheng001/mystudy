package com.panda.study.designmodel_gp.proxy.dynamicproxy.gpproxy.client;/**
 * Created by My on 2020-03-02.
 */


/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:03:10 2020-03-02
 * @Modified By:
 */
public class ZhaoLiu implements IPerson {
    @Override
    public void findLove() {
        System.out.println("儿子要求:有车有房高学历。");
    }

    @Override
    public void buyInsurance() {
        System.out.println("我要买100万的");
    }
}
