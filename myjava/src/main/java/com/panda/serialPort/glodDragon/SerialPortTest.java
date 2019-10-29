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
}
