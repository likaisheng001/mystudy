package com.panda.study.designmodel_gp.flyweight.pool;/**
 * Created by My on 2020-03-10.
 */

import java.sql.Connection;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 19:28:40 2020-03-10
 * @Modified By:
 */
public class ConnectionInfo {
    private Connection conn;
    private boolean isActive = false; // 外部状态
    private boolean isRelease = false; // 外部状态

    public ConnectionInfo(Connection conn){
        this.conn = conn;
    }
}
