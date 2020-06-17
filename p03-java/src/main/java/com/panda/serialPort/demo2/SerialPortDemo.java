/*
package com.panda.serialPort.demo2;

import gnu.io.SerialPort;

import java.util.HashMap;

*/
/**
 * @Author: Likaisheng
 * @Description: 使用CXTX实现java串口通信  -- 存在中文乱码问题
 * @Date: Created in 16:36 2019/10/17
 * @Modified By:
 *//*

public class SerialPortDemo {
    public static void main(String[] args) {
        HashMap<String, Comparable> params = new HashMap<String, Comparable>();
        params.put(SerialReader.PARAMS_PORT, "COM5"); // 端口名称
        params.put(SerialReader.PARAMS_RATE, 600); // 波特率
        params.put(SerialReader.PARAMS_TIMEOUT, 1000); // 设备超时时间 1秒
        params.put(SerialReader.PARAMS_DELAY, 200); // 端口数据准备时间 1秒
        params.put(SerialReader.PARAMS_DATABITS, SerialPort.DATABITS_8); // 数据位
        params.put(SerialReader.PARAMS_STOPBITS, SerialPort.STOPBITS_1); // 停止位
        params.put(SerialReader.PARAMS_PARITY, SerialPort.PARITY_NONE); // 无奇偶校验
        SerialReader sr = new SerialReader(params);
        CommDataObserver bob = new CommDataObserver("bob");
        CommDataObserver joe = new CommDataObserver("joe");
        sr.addObserver(joe);
        sr.addObserver(bob);
    }
}
*/
