package com.panda.jvm;/**
 * Created by My on 2019-12-22.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 21:53:44 2019-12-22
 * @Modified By:
 */
public class HighCpuTest {
    public static void main(String[] args) {
        Long l = 0L;
        while (true){
            System.out.println(l++);
        }
    }
}
