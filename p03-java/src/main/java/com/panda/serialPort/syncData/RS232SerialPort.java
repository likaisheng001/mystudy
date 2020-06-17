/*
package com.panda.serialPort.syncData;

import gnu.io.*;

import java.io.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.TooManyListenersException;

*/
/**
 * @Author: Likaisheng
 * @Description: 使用RXTX实现java串口通信
 * @Date: Created in 14:29 2019/10/17
 * @Modified By:
 *//*

public class RS232SerialPort implements Runnable, SerialPortEventListener {
    private static LinkedList<Byte> RECEIVEBYTES = new LinkedList<Byte>();

    private String appName = "Java串口通信测试";
    private int timeout = 2000;
    private int threadTime = 0;

    private CommPortIdentifier commPort;
    private SerialPort serialPort;
    private InputStream inputStream;
    private OutputStream outputStream;



    //选择串口
    public void selectPort(String portName) {

        this.commPort = null;
        CommPortIdentifier cpid;
        Enumeration en = CommPortIdentifier.getPortIdentifiers();

        while (en.hasMoreElements()) {
            cpid = (CommPortIdentifier) en.nextElement();
            if (cpid.getPortType() == CommPortIdentifier.PORT_SERIAL
                    && cpid.getName().equals(portName)) {
                this.commPort = cpid;
                break;
            }
        }
        openPort();
    }

    //打开串口(串口是串行端口)
    private void openPort() {
        if (commPort == null) {

        } else {


            try {
                serialPort = (SerialPort) commPort.open(appName, timeout);

            } catch (PortInUseException e) {
                throw new RuntimeException(String.format("端口'%1$s'正在使用中！",
                        commPort.getName()));
            }
        }
    }

    //检查端口是否正确连接
    private void checkPort() {
        if (commPort == null) {
            throw new RuntimeException("没有选择端口，请使用 selectPort(String portName) 方法选择端口");
        }
        if (serialPort == null) {
            throw new RuntimeException("SerialPort 对象无效！");
        }
    }

    //向端口写数据，请在调用此方法前，先选择端口，并确定SerialPort正常打开
    public void write(String message) {
        checkPort();

        try {
            outputStream = new BufferedOutputStream(serialPort.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException("获取端口的OutputStream出错：" + e.getMessage());
        }

        try {
            //将发送的数据转成十六进制
            outputStream.write(RS232SerialPort.hexStringToBytes(message));
            //outputStream.write(message.getBytes());

        } catch (IOException e) {
            throw new RuntimeException("向端口发送信息时出错：" + e.getMessage());
        } finally {
            try {
                outputStream.close();
            } catch (Exception e) {
            }
        }
    }

    */
/**
     * 开始监听从端口中接收的数据
     *
     * @param time 监听程序的存活时间，单位为秒，0 则是一直监听
     * @Return void
     *//*

    public void startRead(int time) {
        checkPort();

        try {
            inputStream = serialPort.getInputStream();
            // inputStream = new BufferedInputStream(serialPort.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException("获取端口的InputStream出错：" + e.getMessage());
        }

        try {
            serialPort.addEventListener(this);
        } catch (TooManyListenersException e) {
            throw new RuntimeException(e.getMessage());
        }

        serialPort.notifyOnDataAvailable(true);

        if (time > 0) {
            this.threadTime = time * 1000;
            Thread t = new Thread(this);
            t.start();

        }
    }

    //关闭 SerialPort
    public void close() {
        serialPort.close();
        serialPort = null;
        commPort = null;
    }

    //数据接收的监听处理函数
    @Override
    public void serialEvent(SerialPortEvent arg0) {
        switch (arg0.getEventType()) {
            case SerialPortEvent.BI:*/
/*Break interrupt,通讯中断*//*

            case SerialPortEvent.OE:*/
/*Overrun error，溢位错误*//*

            case SerialPortEvent.FE:*/
/*Framing error，传帧错误*//*

            case SerialPortEvent.PE:*/
/*Parity error，校验错误*//*

            case SerialPortEvent.CD:*/
/*Carrier detect，载波检测*//*

            case SerialPortEvent.CTS:*/
/*Clear to send，清除发送*//*

            case SerialPortEvent.DSR:*/
/*Data set ready，数据设备就绪*//*

            case SerialPortEvent.RI:*/
/*Ring indicator，响铃指示*//*

            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:*/
/*Output buffer is empty，输出缓冲区清空*//*

                break;
            case SerialPortEvent.DATA_AVAILABLE:*/
/*Data available at the serial port，端口有可用数据。读到缓冲数组，输出到终端*//*


                byte[] readBuffer = new byte[1024];
                String s2 = "";
                try {
                    while (inputStream.available() > 0) {
                        int len = inputStream.read(readBuffer);
                        for (int i = 0; i < len; i++) {
                            RECEIVEBYTES.add(readBuffer[i]);
                        }
                    }
                } catch (IOException e) {
                    System.out.println(e);
                }
        }
    }


    @Override
    public void run() {
        try {
            Thread.sleep(threadTime);
            serialPort.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    */
/**
     * 将十六进制字符串转换成byte数组
     *
     * @param str
     * @return
     *//*

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

    public static LinkedList<Byte> getRECEIVEBYTES() {
        return RECEIVEBYTES;
    }

    */
/**
     * 工具方法，将byte[]转换成十六进制返回，只支持100字节以内的byte数组
     *
     * @param bytes
     *//*

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
}*/
