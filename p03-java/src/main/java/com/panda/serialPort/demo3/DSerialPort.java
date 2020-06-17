/*
package com.panda.serialPort.demo3;

import gnu.io.*;

import java.io.*;
import java.util.Enumeration;
import java.util.TooManyListenersException;

*/
/**
 * @Author: Likaisheng
 * @Description: 使用RXTX实现java串口通信
 * @Date: Created in 14:29 2019/10/17
 * @Modified By:
 *//*

public class DSerialPort implements Runnable, SerialPortEventListener {

    private String appName = "Java串口通信测试";
    private int timeout = 2000;
    private int threadTime = 0;

    private CommPortIdentifier commPort;
    private SerialPort serialPort;
    private InputStream inputStream;
    private OutputStream outputStream;

    //罗列串口
    public void listPorts() {
        CommPortIdentifier cpid;
        Enumeration en = CommPortIdentifier.getPortIdentifiers();

        System.out.println("now to list all Port of this PC：" + en);
        System.out.println("list all ports of the pc:" + en);

        while (en.hasMoreElements()) {
            cpid = (CommPortIdentifier) en.nextElement();
            if (cpid.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                System.out.println(cpid.getName() + "," + cpid.getCurrentOwner());
            }
        }
    }
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
        if (commPort == null){
            log(String.format("无法找到名字为'%1$s'的串口！", commPort.getName()));
        } else {
            log("端口选择成功，当前端口：" + commPort.getName() + ",现在实例化 SerialPort:");

            try {
                serialPort = (SerialPort) commPort.open(appName, timeout);
                log("实例 SerialPort 成功！");
            } catch (PortInUseException e) {
                throw new RuntimeException(String.format("端口'%1$s'正在使用中！",
                        commPort.getName()));
            }
        }
    }

    //检查端口是否正确连接
    private void checkPort() {
        if (commPort == null){
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
            outputStream.write(message.getBytes());
            log("信息发送成功！");
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
     * @param time 监听程序的存活时间，单位为秒，0 则是一直监听
     * @Return void
     *//*

    public void startRead(int time) {
        checkPort();

        try {

            inputStream = new BufferedInputStream(serialPort.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException("获取端口的InputStream出错：" + e.getMessage());
        }

        try {
            serialPort.addEventListener(this);
        } catch (TooManyListenersException e) {
            throw new RuntimeException(e.getMessage());
        }

        serialPort.notifyOnDataAvailable(true);

        log(String.format("开始监听来自'%1$s'的数据--------------", commPort.getName()));
        if (time > 0) {
            this.threadTime = time * 1000;
            Thread t = new Thread(this);
            t.start();
            log(String.format("监听程序将在%1$d秒后关闭。。。。", threadTime));
        }
    }

    //关闭 SerialPort
    public void close() {
        serialPort.close();
        serialPort = null;
        commPort = null;
    }

    public void log(String msg) {
        System.out.println(appName + " --> " + msg);
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
                String readStr = "";
                String s2 = "";

                try {

                    while (inputStream.available() > 0) {
                        inputStream.read(readBuffer);
                        readStr += new String(readBuffer,"GBK").trim();
                    }
                    s2 = new String(readBuffer,"GBK").trim();

                    log("接收到端口返回数据(长度为" + readStr.length() + ")：" + readStr);
                    log(s2);
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
            log(String.format("端口''监听关闭了！", commPort.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/
