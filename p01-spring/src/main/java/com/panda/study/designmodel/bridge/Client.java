package com.panda.study.designmodel.bridge;

/**
 * Created by Administrator on 2019/7/30.
 */
public class Client {
    public static void main(String[] args) {
        //获取折叠式手机(样式+品牌)
        Phone phone = new FoldedPhone(new XiaoMi());
        phone.open();
        phone.call();
        phone.close();
        System.out.println("------------------------");
        Phone phone2 = new FoldedPhone(new Vivo());
        phone2.open();
        phone2.call();
        phone2.close();
        System.out.println("-----------------------");
        Phone phone3 = new FoldedPhone(new XiaoMi());
        phone3.open();
        phone3.call();
        phone3.close();
    }
}
