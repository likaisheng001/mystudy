package com.panda.jvm;
/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:04:31 2019-12-16
 * @Modified By:
 */
public class HelloWorld {
    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){
            try {
                Thread.sleep(1000);
                System.out.println("Hello World!!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
