package com.panda_db.test;

import com.panda_db.spring.db.dao.MemberDao;
import com.panda_db.spring.db.entity.Member;
import com.panda_db.spring.db.entity.Order;
import com.panda_db.spring.db.dao.OrderDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 14:46:37 2019-12-20
 * @Modified By:
 */
@ContextConfiguration(locations = {"classpath:application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrmTest {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmdd");

    @Autowired private MemberDao memberDao;

    @Autowired private OrderDao orderDao;

    @Test
    public void testSelectAllForMember(){
        try {
            List<Member> result = memberDao.selectAll();
            System.out.println(Arrays.toString(result.toArray()));
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(memberDao);
    }

    @Test
//	@Ignore
    public void testInsertOrder(){
        try {
            Order order = new Order();
            order.setMemberId(1L);
            order.setDetail("新订单");
            //Date date = sdf.parse("20190201123456");
            //order.setCreateTime(date.getTime());
            orderDao.insertOne(order);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
