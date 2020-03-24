package com.panda.study.designmodel_gp.visitor.dispatch;/**
 * Created by My on 2020-03-24.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:35:20 2020-03-24
 * @Modified By:
 */
public class DynamicDispatch {
    public static void main(String[] args) {
        Person man = new Man();
        Person woman = new Woman();

        man.test();
        woman.test();
    }
}
