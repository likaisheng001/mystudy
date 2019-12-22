package com.panda.pattern.proxy.dbroute;/**
 * Created by My on 2019-12-20.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 21:54:52 2019-12-20
 * @Modified By:
 */
public class OrderDao {
    public int insert(Order order){
        System.out.println("OrderDao创建Order成功!");
        return 1;
    }
}
