package com.panda.serialPort.glodDragon;

import gnu.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.TooManyListenersException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Likaisheng
 * @Description: java对接rs232串口 - 只用于地磅
 *                串口通信有两种模式：连续模式(只读)和命令模式(读写)
 *                串口通信步骤：
 *                1.选择串口 - CommPortIdentifier commPort - 找到需要连接的端口Identifier
 *                2.打开串口
 *                3.连接串口(设置串口参数：数据位、波特率等等，为通信做准备)
 *                4.与串口交互(根据实际情况,选择具体的通信模式)
 *                5.关闭串口
 *                备注：没有使用串口监听器来监听并读取数据。如果电脑的反应速度过快，串口有可用数据时触发。
 *                此时一帧数据只被读到了几个字节，然后又需要触发，读一帧数据需要触发几次，不利于数据的后续处理。
 * @Date: Created in 14:35 2019/10/23
 * @Modified By:
 */
public class RS232SerialPort{
    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,3,10, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());

    private String mode = "read";
    private static LinkedList<Byte> RECEIVEBYTES = new LinkedList<Byte>();
    private String owner; // 访问人
    private int timeout = 2000;
    private int threadTime = 0;

    private CommPortIdentifier commPort;
    private SerialPort serialPort;

    private Thread readThread;

    public RS232SerialPort(String mode) {
        this.mode = mode;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public static LinkedList<Byte> getRECEIVEBYTES() {
        return RECEIVEBYTES;
    }

    //罗列所有的串口
    public void listPorts(){
        CommPortIdentifier cpid;
        Enumeration en = CommPortIdentifier.getPortIdentifiers();

        while (en.hasMoreElements()){
            cpid = (CommPortIdentifier)en.nextElement();
            if (cpid.getPortType() == CommPortIdentifier.PORT_SERIAL){
                System.out.println("串口名：" + cpid.getName() + ",串口用户:" + cpid.getCurrentOwner());
            }
        }
    }

    //1.选择串口
    public void selectPort(String portName){
        this.commPort = null;
        CommPortIdentifier cpid;
        Enumeration en = CommPortIdentifier.getPortIdentifiers();

        while (en.hasMoreElements()){
            cpid = (CommPortIdentifier)en.nextElement();
            if (cpid.getPortType() == CommPortIdentifier.PORT_SERIAL
                    && cpid.getName().equals(portName)){
                this.commPort = cpid;
                break;
            }
        }
    }

    //2.打开串口
    public void openPort(){
        if (commPort == null){
            throw new WeighBridgeException("串口不存在");
        }
        try{
            serialPort = (SerialPort)commPort.open(owner, timeout);
            System.out.println("端口:"+commPort.getName()+" 已打开");
        }catch (PortInUseException e){
            throw new RuntimeException(String.format("端口'%1$s'正在使用中！",
                    commPort.getName()));
        }
    }

    //3.与串口交互
    public void interact(){

    }
    //检查端口是否正确连接
    private void checkPort(){
        if (commPort == null) {
            throw new RuntimeException("没有选择端口，请使用 selectPort(String portName) 方法选择端口");
        }
        if (serialPort == null) {
            throw new RuntimeException("SerialPort 对象无效！");
        }
    }


    //开启读
    public void startRead(int time){
        if (mode != "read"){
            throw new RuntimeException("串口处于命令模式，不支持开启连续读！");
        }
        checkPort();
        OnlyRead OnlyRead = null;
        try {
            OnlyRead = new OnlyRead(serialPort.getInputStream(),12000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        threadPool.execute(OnlyRead);
    }
    public void write(byte[] bytes){
        if (mode != "write"){
            throw new RuntimeException("串口处于连读模式，不支持开启命令模式！");
        }
        checkPort();
        try {
            CmdRead cmdRead = new CmdRead(serialPort.getInputStream());
            threadPool.execute(cmdRead);
            CmdWrite CmdWrite = new CmdWrite(serialPort.getOutputStream(),bytes);
            threadPool.execute(CmdWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //4.关闭串口
    public void close(){
        serialPort.close();
        serialPort = null;
        commPort = null;
    }

    private boolean verify(){
        return false;
    }
    private byte[] addVerifyCode(){
        return null;
    }
    private byte[] addStartBit(){
        return null;
    }
    class CmdWrite implements Runnable{
        private OutputStream outputStream;
        private byte[] bytes;

        public CmdWrite(OutputStream outputStream, byte[] bytes) {
            this.outputStream = outputStream;
            this.bytes = bytes;
        }

        @Override
        public void run() {
            try {
                outputStream.write(bytes);
            } catch (IOException e) {
                throw new RuntimeException("向端口发送信息时出错：" + e.getMessage());
            } finally {
                try {
                    outputStream.close();
                } catch (IOException e) {
                }
            }
        }
    }
    class OnlyRead implements Runnable,SerialPortEventListener{
        private InputStream inputStream;
        private int threadTime = 12000;

        public OnlyRead(InputStream inputStream, int threadTime) {
            this.inputStream = inputStream;
            this.threadTime = threadTime;
            init();
        }

        public void init(){
            //设置通信规则
            try {
                serialPort.setSerialPortParams(9600,
                        SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1,
                        SerialPort.PARITY_NONE);
            } catch (UnsupportedCommOperationException e) {
                e.printStackTrace();
            }
            try {
                /*获取端口的输入流对象*/
                inputStream = serialPort.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try{
                serialPort.addEventListener(this);
            }catch (TooManyListenersException e){
                throw new RuntimeException(e.getMessage());
            }
            serialPort.notifyOnDataAvailable(true);
        }
        @Override
        public void run() {
            //暂时一直运行，直到程序结束
            //此处如何让它一直沉睡，而又不断监听
            try {
                Thread.sleep(12000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            serialPort.close();
        }
        //数据接收的监听处理函数
        @Override
        public void serialEvent(SerialPortEvent arg0) {
            switch (arg0.getEventType()) {
                case SerialPortEvent.BI:/*Break interrupt,通讯中断*/
                case SerialPortEvent.OE:/*Overrun error，溢位错误*/
                case SerialPortEvent.FE:/*Framing error，传帧错误*/
                case SerialPortEvent.PE:/*Parity error，校验错误*/
                case SerialPortEvent.CD:/*Carrier detect，载波检测*/
                case SerialPortEvent.CTS:/*Clear to send，清除发送*/
                case SerialPortEvent.DSR:/*Data set ready，数据设备就绪*/
                case SerialPortEvent.RI:/*Ring indicator，响铃指示*/
                case SerialPortEvent.OUTPUT_BUFFER_EMPTY:/*Output buffer is empty，输出缓冲区清空*/
                    break;
                case SerialPortEvent.DATA_AVAILABLE:/*Data available at the serial port，端口有可用数据。读到缓冲数组，输出到终端*/

                    try {
                        //串口传输频率是100ms,此时沉睡，是为了完整的接收一次发送数据
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    byte[] readBuffer = new byte[1024];
                    try {
                        while (inputStream.available() > 0) {
                            int len = inputStream.read(readBuffer);
                            for (int i = 0; i < len; i++) {
                                RECEIVEBYTES.add(readBuffer[i]);
                                System.out.print(readBuffer[i] + " ");;
                            }
                            System.out.println();
                        }
                    } catch (IOException e) {
                        System.out.println(e);
                    }
            }
        }
    }
    class CmdRead implements Runnable {
        private InputStream inputStream;
        private int threadTime = 100;//默认100毫秒

        public CmdRead(InputStream inputStream) {
            this.inputStream = inputStream;
            init();
        }

        public void init() {
            //设置通信规则
            try {
                serialPort.setSerialPortParams(9600,
                        SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1,
                        SerialPort.PARITY_NONE);
            } catch (UnsupportedCommOperationException e) {
                e.printStackTrace();
            }
            try {
                /*获取端口的输入流对象*/
                inputStream = serialPort.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            serialPort.notifyOnDataAvailable(true);
        }

        @Override
        public void run() {
            byte[] readBuffer = new byte[1024];
            long startTime = System.currentTimeMillis();
            long currendTime = System.currentTimeMillis();
            loop1: while (true){
                currendTime = System.currentTimeMillis();
                if (currendTime - startTime > threadTime){
                    throw new RuntimeException("等待超时");
                }
                try {
                    while (inputStream.available() > 0) {
                        int len = inputStream.read(readBuffer);
                        for (int i = 0; i < len; i++) {
                            RECEIVEBYTES.add(readBuffer[i]);
                            System.out.print(readBuffer[i] + " ");
                            if (readBuffer[i] == 3){
                                break loop1;
                            }
                        }
                        System.out.println();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
