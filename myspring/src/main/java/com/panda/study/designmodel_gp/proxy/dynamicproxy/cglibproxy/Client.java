package com.panda.study.designmodel_gp.proxy.dynamicproxy.cglibproxy;/**
 * Created by My on 2020-03-02.
 */

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:31:38 2020-03-02
 * @Modified By:
 */
public class Client {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"D:\\cglib_proxy_classes");
        CglibMeipo cglibMeipo = new CglibMeipo();
        Zhangsan zhangsan = (Zhangsan)cglibMeipo.getInstance(Zhangsan.class);
        zhangsan.findLove();
    }
}
