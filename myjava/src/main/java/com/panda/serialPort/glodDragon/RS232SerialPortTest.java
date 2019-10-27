package com.panda.serialPort.glodDragon;/**
 * Created by My on 2019-10-26.
 */

import gnu.io.SerialPort;
import org.junit.Test;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 12:27:11 2019-10-26
 * @Modified By:
 */
public class RS232SerialPortTest {
    public static void main(String[] args) {
        RS232SerialPort rs232SerialPort = new RS232SerialPort();
        rs232SerialPort.initSerialPort(9600, SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE,"COM1","测试");
        rs232SerialPort.verify();
    }
    @Test
    public void test1(){
        byte[] buf = new byte[8];
        buf[0] = 4;
        buf[1] = 1;
        buf[2] = 4;
        buf[3] = 1;
        buf[4] = 3;
        buf[5] = 0;
        buf[6] = 3;
        buf[7] = 0;

        byte b = buf[0];
        for (int i = 1; i < buf.length-4; i++) {
            b = (byte)(b ^ buf[i]);
        }
        System.out.println("输出校验位:"+b);
    }
    //在测试异步读时，需要把main线程阻塞，main线程一旦结束，整个程序就结束了
    //注意：具体情况并未测试，时间充裕要详细测试 - 如果main线程结束了，系统的线程资源并未释放，这很危险！！！
    @Test
    public void asyReadTest(){
        RS232SerialPort rs232SerialPort = new RS232SerialPort();
        rs232SerialPort.initSerialPort(9600, SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE,"COM1","测试");
        rs232SerialPort.asyRead();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
