package com.panda.pattern.proxy.staticproxy;/**
 * Created by My on 2019-12-20.
 */

/**
 * @Author: Likaisheng
 * @Description: 父亲只会给自己的儿子代理 代理类和被代理类一一对应（静态代理）
 * @Date: Created in 21:45:35 2019-12-20
 * @Modified By:
 */
public class FatherProxyTest {
    public static void main(String[] args) {
        Father father = new Father(new Son());
        father.findLove();

        //农村：媒婆(动态代理)
        //媒介所

        //大家每天都在用的一种静态代理模式
        //对数据库进行分库分表
        //ThreadLocal
        //进行数据源动态切换
    }
}
