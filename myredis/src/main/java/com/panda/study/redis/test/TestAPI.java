package com.panda.study.redis.test;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by Administrator on 2019/7/9.
 */
public class TestAPI {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.1.117", 6379);
        String s1 = jedis.get("k1");
        System.out.println(s1);
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
    }
}
