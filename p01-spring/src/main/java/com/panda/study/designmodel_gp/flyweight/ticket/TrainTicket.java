package com.panda.study.designmodel_gp.flyweight.ticket;/**
 * Created by My on 2020-03-10.
 */

import java.util.Random;

/**
 * @Author: Likaisheng
 * @Description: 具体的享元对象
 * @Date: Created in 18:45:23 2020-03-10
 * @Modified By:
 */
public class TrainTicket implements ITicket {
    private String from;
    private String to;
    private int price;

    public TrainTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void showInfo(String bunk) {
        this.price = new Random().nextInt(500);
        System.out.println(from + "->" + to + ":" + bunk + "价格：" + this.price);
    }
}
