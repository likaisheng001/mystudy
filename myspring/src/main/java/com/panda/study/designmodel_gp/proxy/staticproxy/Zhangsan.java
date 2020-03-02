package com.panda.study.designmodel_gp.proxy.staticproxy;/**
 * Created by My on 2020-03-02.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:03:10 2020-03-02
 * @Modified By:
 */
public class Zhangsan implements IPerson {
    @Override
    public void findLove() {
        System.out.println("儿子要求:肤白貌美大长腿。");
    }
}
