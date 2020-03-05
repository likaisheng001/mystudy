package com.panda.study.study.redis.test;

import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2019/7/9.
 */
public class TestPing {
    public static void main(String[] args) {
        //192.168.1.117  注意需关闭Linux的防火墙
        Jedis jedis = new Jedis("192.168.1.117", 6379);
        String result = jedis.ping();
        System.out.println("********ping:" + result);
    }
}
