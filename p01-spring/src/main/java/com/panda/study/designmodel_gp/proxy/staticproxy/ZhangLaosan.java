package com.panda.study.designmodel_gp.proxy.staticproxy;/**
 * Created by My on 2020-03-02.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:03:30 2020-03-02
 * @Modified By:
 */
public class ZhangLaosan implements IPerson {
    private Zhangsan zhangsan;

    public ZhangLaosan(Zhangsan zhangsan) {
        this.zhangsan = zhangsan;
    }

    @Override
    public void findLove() {
        System.out.println("张老三开始物色");
        zhangsan.findLove();
        System.out.println("开始交往");
    }
}
