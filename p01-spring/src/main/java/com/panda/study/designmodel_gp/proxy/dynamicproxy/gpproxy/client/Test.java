package com.panda.study.designmodel_gp.proxy.dynamicproxy.gpproxy.client;/**
 * Created by My on 2020-03-02.
 */


import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:16:02 2020-03-02
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        GpMeipo gpMeipo = new GpMeipo();
        IPerson zhangsan = gpMeipo.getInstance(new Zhangsan());
        zhangsan.findLove();

        zhangsan.sayHello("梦梦");
    }
}
