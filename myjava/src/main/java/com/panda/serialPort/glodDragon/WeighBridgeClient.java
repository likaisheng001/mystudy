package com.panda.serialPort.glodDragon;/**
 * Created by My on 2019-10-27.
 */

import gnu.io.SerialPort;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:55:53 2019-10-27
 * @Modified By:
 */
public class WeighBridgeClient {
    public Float getWeighBridgeData(){
        RS232SerialPort rs232SerialPort = new RS232SerialPort();
        rs232SerialPort.initSerialPort(9600, SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE,"COM1","测试");
        byte[] buf = rs232SerialPort.read(20000);
        boolean verify = WeighBridgeUtil.verify(buf);
        System.out.println("校验结果:" + verify);
        String str = WeighBridgeUtil.interpretData(buf, 0, buf.length - 2);
        System.out.println("解析得到的数据为:"+str);
        float result = Float.parseFloat(str);
        System.out.println("最终的结果为:"+result);
        return result;
    }
}
