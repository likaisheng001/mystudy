package com.panda.QRcode;

import java.io.File;

/**
 * 二维码分成两部分：
 * 1.二维码的生成
 * 2.二维码的解析
 */
public class QRcodeTest {
    public static void main(String[] args) throws Exception {
//        System.out.println("测试二维码生成");
//        generateCode();
        System.out.println("测试二维码解析");
        analysisCode();
    }
    public static void generateCode() throws Exception {
        String text = "https://www.baidu.com/"; //二维码内容
        QRCodeUtil.encode(text,"D:/",true);
    }
    public static void analysisCode() throws Exception {
        String path = "D:" + File.separator + "80809307.jpg";
        String decode = QRCodeUtil.decode(path);
        System.out.println(decode);
    }
}
