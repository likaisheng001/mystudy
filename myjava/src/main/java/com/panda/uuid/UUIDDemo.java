package com.panda.uuid;/**
 * Created by My on 2019-10-29.
 */

import java.util.UUID;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:41:20 2019-10-29
 * @Modified By:
 */
public class UUIDDemo {
    public static void main(String[] args) {
        String uuidStr = UUID.randomUUID().toString();
        System.out.println("uuidStr:"+uuidStr);
    }
}
