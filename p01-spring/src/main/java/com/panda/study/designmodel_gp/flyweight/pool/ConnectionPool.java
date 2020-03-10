package com.panda.study.designmodel_gp.flyweight.pool;/**
 * Created by My on 2020-03-10.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

/**
 * @Author: Likaisheng
 * @Description: 可用ConnectionInfo来优化这个类
 * @Date: Created in 18:56:36 2020-03-10
 * @Modified By:
 */
public class ConnectionPool {
    private Vector<Connection> pool;
    private int poolSize = 100;
    private String url = "jdbc:mysql://localhost:3306/test";
    private String username = "root";
    private String password = "root";
    private String driverClassName = "com.mysql.jdbc.Driver";

    public ConnectionPool(){
        pool = new Vector<Connection>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            try {
                Class.forName(driverClassName);
                Connection conn = DriverManager.getConnection(url, username, password);
                pool.add(conn);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public synchronized Connection getConnection(){
        if (pool.size() > 0){
            Connection conn = pool.get(0);
            pool.remove(conn);
            return conn;
        }
        return null;
    }

    public synchronized void release(Connection conn){
        pool.add(conn);
    }
}
