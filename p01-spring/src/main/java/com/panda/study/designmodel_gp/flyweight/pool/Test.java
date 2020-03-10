package com.panda.study.designmodel_gp.flyweight.pool;/**
 * Created by My on 2020-03-10.
 */

import java.sql.Connection;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 19:02:40 2020-03-10
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool();
        Connection conn = pool.getConnection();
        System.out.println(conn);
    }
}
