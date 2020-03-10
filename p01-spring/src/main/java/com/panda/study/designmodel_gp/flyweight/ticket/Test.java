package com.panda.study.designmodel_gp.flyweight.ticket;/**
 * Created by My on 2020-03-10.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:51:36 2020-03-10
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        ITicket ticket = TicketFactory.queryTickket("北京西","长沙");
        ticket.showInfo("硬座");

        ITicket ticket2 = TicketFactory.queryTickket("北京西","长沙");
        ticket2.showInfo("软座");

        ITicket ticket3 = TicketFactory.queryTickket("北京西","重庆");
        ticket3.showInfo("硬座");
    }
}
