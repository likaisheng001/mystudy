package com.panda.study.designmodel_gp.proxy.staticproxy;/**
 * Created by My on 2020-03-02.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:05:12 2020-03-02
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        ZhangLaosan zhangLaosan = new ZhangLaosan(new Zhangsan());
        zhangLaosan.findLove();
    }
}
