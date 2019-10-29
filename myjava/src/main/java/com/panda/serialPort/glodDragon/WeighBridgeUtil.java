package com.panda.serialPort.glodDragon;/**
 * Created by My on 2019/10/23.
 */

import java.util.Arrays;

/**
 * @Author: Likaisheng
 * @Description: 地磅对接的工具类
 * @Date: Created in 14:34 2019/10/23
 * @Modified By:
 */
public class WeighBridgeUtil {
    /**
     * 工具方法，将byte[]转换成十六进制返回，只支持100字节以内的byte数组
     *
     * @param bytes
     */
    public static String stringToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder(100);
        for (int i = 0; i < bytes.length; i++) {
            String hexStr = Integer.toHexString(bytes[i] & 0xFF) + " ";
            if (hexStr.length() == 2) {
                hexStr = '0' + hexStr;
            }
            builder.append(hexStr);
        }
        return builder.toString();
    }

    /**
     * 将十六进制字符串转换成byte数组
     *
     * @param str
     * @return
     */
    public static byte[] hexStringToBytes(String str) {
        //此处并未校验传入参数是否合法
        //此处保证传入的字符串为偶数，方便后续处理
        if (str.length() % 2 != 0) {
            str = "0" + str;
        }
        String[] strs = str.split("");
        byte[] bytes = new byte[strs.length];
        byte[] bytes2 = new byte[(strs.length) / 2]; //此处预先判断一下，传入的必须是偶数个字符，如果不足，就手动补一个
        for (int i = 0; i < strs.length; i++) {
            bytes[i] = Byte.parseByte(strs[i]);
        }
        //进制转换 - 舍高4位，取低4位，将两个字节合并为一个
        int idx = 0;
        byte b1, b2 = 0;
        for (int i = 0; i < bytes.length; i += 2) {
            b1 = 0;
            b2 = 0;
            b1 = (byte) (bytes[i] << 4);         //抹掉高4位
            b2 = (byte) (bytes[i + 1] & 0xf);      //抹掉低4位
            bytes2[idx++] = (byte) (b1 | b2);
        }
        return bytes2;
    }
    //检验
    public static boolean verify(byte[] buf){
        byte bl,br;  //bl保存校验位的高四位,br保存校验位的低四位

        byte b = buf[0];
        for (int i = 1; i < buf.length-2; i++) {
            b = (byte)(b ^ buf[i]);
        }

        //处理校验位
        bl = (byte)(b >>> 4);
        br = (byte)(b & 15);
        if (bl <= 9){ //如果校验高位小于等于9，则加30h
            bl += 30;
        }
        if (br <= 9){ //如果校验低位小于等于9，则加30h
            br += 30;
        }
        String sl = Integer.toHexString(buf[buf.length - 2]);
        String sr = Integer.toHexString(buf[buf.length - 1]);
        if (sl.equals(bl+"") && sr.equals(br+"")){
            return true;
        }
        return false;
    }
    //解析称重数据
    public static String interpretData(byte[] buf,int start,int end){
        StringBuilder builder = new StringBuilder("");
        byte[] bytes = new byte[end-start];
        int idx = 0;
        for (int i = start; i < end; i++){
            bytes[idx++] = buf[i];
        }
        char[] chars = WeighBridgeUtil.bytesToStr(bytes);

        //处理小数点
        int i = chars[chars.length - 1] - '0';
        int j = chars.length-1;
        for (; i > 0; i--,j--) {
            chars[j] = chars[j-1];
        }
        chars[j]='.';

        //准备要返回的数据
        for (int k = 0; k < chars.length; k++) {
            builder.append(chars[k]);
        }
        return builder.toString();
    }
    public static char[] bytesToStr(byte[] buf){
        char[] charBuf = new char[buf.length];
        for (int i = 0; i < buf.length; i++) {
            charBuf[i] = (char)buf[i];
        }
        return charBuf;
    }
}
