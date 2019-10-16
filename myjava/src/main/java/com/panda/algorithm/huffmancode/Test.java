package com.panda.algorithm.huffmancode;

/**
 * Created by Administrator on 2019/7/17.
 */
public class Test {
    public static void main(String[] args) {
        //二进制转换
        //byte[推导10101000 => 10101000-1 => 10100111(反码) => 11011000 => -88]
        String strByte = "10101000";
        //System.out.println((byte)Integer.parseInt(strByte,2)); -88
        //使用Integer.parseInt方法 字符串10101000 会被转成 00000000 00000000 00000000 10101000 所以输出会是168
        System.out.println(Integer.parseInt(strByte,2));

        byte b = -78;
        int b2 = b;
        System.out.println("b2="+b2);
    }
}
