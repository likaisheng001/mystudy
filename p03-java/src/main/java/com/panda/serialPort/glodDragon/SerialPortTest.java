package com.panda.serialPort.glodDragon;/**
 * Created by My on 2019-10-26.
 */

import gnu.io.SerialPort;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author: Likaisheng
 * @Description:测试SerialPortBase类和SerialPortComm类
 * @Date: Created in 10:33:29 2019-10-26
 * @Modified By:
 */
public class SerialPortTest {
    public static void main(String[] args) {
        SerialPortBase serialPortBase = new SerialPortBase("测试");
        serialPortBase.openPort("COM1");
        serialPortBase.configSerialPortParams(9600, SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);

        SerialPortComm serialPortComm = new SerialPortComm(serialPortBase.getSerialPort());
        try {
            byte[] read = serialPortComm.read(10000);
            for (int i = 0; i < read.length; i++){
                System.out.print(read[i]+" ");
            }
            System.out.println();
            serialPortComm.write("hello world!".getBytes());
            serialPortComm.syncRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void showPorts(){
        SerialPortBase serialPortBase = new SerialPortBase("测试");
        serialPortBase.listPorts();
        serialPortBase.openPort("127.0.0.1:COM1");
    }
    @Test
    public void verify(){
        //String str = "41 44 2B 30 30 36 38 34 30 32";
        byte[] arr2 = new byte[10];
        arr2[0] = 65;
        arr2[1] = 68;
        arr2[2] = 43;
        arr2[3] = 48;
        arr2[4] = 48;
        arr2[5] = 54;
        arr2[6] = 56;
        arr2[7] = 52;
        arr2[8] = 48;
        arr2[9] = 50;

        byte b = arr2[0];
        for (int i = 1; i < arr2.length-2; i++) {
            b = (byte)(b ^ arr2[i]);
        }
        System.out.println("异或后的结果为:"+b); // 22  0001 0110
        //异或高位小于等于9  1+30 = 31； 异或低位小于等于9  6+30 = 36
        /*String[] arr = str.split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr2 = WeighBridgeUtil.hexStringToBytes(arr[i]);
        }*/
    }
}
