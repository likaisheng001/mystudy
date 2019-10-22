package com.panda.serialPort.syncData;/**
 * Created by My on 2019/10/22.
 */

/**
 * @Author: Likaisheng 北京中易银合
 * @Description:
 * @Date: Created in 15:56 2019/10/22
 * @Modified By:
 */
public class SerialPortUtil {
    /**
     * 工具方法，将byte[]转换成十六进制返回，只支持100字节以内的byte数组
     * @param bytes
     */
    public static String stringToHex(byte[] bytes){
        StringBuilder builder = new StringBuilder(100);
        for (int i = 0; i < bytes.length; i++) {
            String hexStr = Integer.toHexString(bytes[i] & 0xFF) + " ";
            if (hexStr.length() == 2){
                hexStr = '0' + hexStr;
            }
            builder.append(hexStr);
        }
        return builder.toString();
    }
}
