package com.panda.serialPort.glodDragon;/**
 * Created by My on 2019/10/23.
 */

/**
 * @Author: Likaisheng
 * @Description: 地磅对接的工具类
 * @Date: Created in 14:34 2019/10/23
 * @Modified By:
 */
public class SerialPortUtil {
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
}
