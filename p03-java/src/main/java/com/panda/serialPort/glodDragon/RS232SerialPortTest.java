/*
package com.panda.serialPort.glodDragon;
*/
/**
 * Created by My on 2019-10-26.
 *//*


import gnu.io.SerialPort;
import org.junit.Test;

*/
/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 12:27:11 2019-10-26
 * @Modified By:
 *//*

public class RS232SerialPortTest {

    //校验测试通过
    @Test
    public void testVerify(){
        RS232SerialPort rs232SerialPort = new RS232SerialPort();
        rs232SerialPort.initSerialPort(9600, SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE,"COM1","测试");
        byte[] buf = rs232SerialPort.read(20000);
        for (int i = 0; i < buf.length; i++) {
            System.out.print("i="+i + ",value="+buf[i] + " ");
        }
        System.out.println();
        boolean verify = WeighBridgeUtil.verify(buf);
        System.out.println("校验结果:" + verify);
    }

    //解析数据测试成功
    @Test
    public void testInterpreteDate(){
        RS232SerialPort rs232SerialPort = new RS232SerialPort();
        rs232SerialPort.initSerialPort(9600, SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE,"COM5","测试");
        byte[] buf = rs232SerialPort.read(20000);
        boolean verify = WeighBridgeUtil.verify(buf);
        System.out.println("校验结果:" + verify);
        String str = WeighBridgeUtil.interpretData(buf, 0, buf.length - 2);
        System.out.println("解析得到的数据为:"+str);
        float result = Float.parseFloat(str);
        System.out.println("最终的结果为:"+result);
    }

    //异步读测试通过
    //在测试异步读时，需要把main线程阻塞，main线程一旦结束，整个程序就结束了
    //注意：具体情况并未测试，时间充裕要详细测试 - 如果main线程结束了，系统的线程资源并未释放，这很危险！！！
    @Test
    public void asyReadTest(){
        RS232SerialPort rs232SerialPort = new RS232SerialPort();
        rs232SerialPort.initSerialPort(9600, SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE,"COM5","测试");
        rs232SerialPort.asyRead();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
*/
