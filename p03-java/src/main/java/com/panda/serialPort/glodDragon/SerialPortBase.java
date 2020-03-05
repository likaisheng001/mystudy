package com.panda.serialPort.glodDragon;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
/**
 * @Author: Likaisheng
 * @Description:该类只负责串口的连接和设置，不处理任何通信任务，
 *               具体的通信任务交给具体的通信类RS232SerialPortComm
 * @Date: Created in 09:16:56 2019-10-26
 * @Modified By:
 */
public class SerialPortBase {
    private CommPortIdentifier commPort;
    private SerialPort serialPort;
    private String owner;  //串口占有者
    private int timeout = 2000; //设置连接超时时间,默认为两秒

    public SerialPortBase(String owner) {
        this.owner = owner;
    }

    public SerialPortBase(String owner, int timeout) {
        this.commPort = commPort;
        this.serialPort = serialPort;
        this.owner = owner;
        this.timeout = timeout;
    }

    //罗列所有的串口
    public void listPorts(){
        CommPortIdentifier cpid;
        Enumeration en = CommPortIdentifier.getPortIdentifiers();
        while (en.hasMoreElements()){
            cpid = (CommPortIdentifier)en.nextElement();
            System.out.println("端口号:"+cpid.getName()+",串口用户:" + cpid.getCurrentOwner());
        }
//        while (en.hasMoreElements()){
//            cpid = (CommPortIdentifier)en.nextElement();
//            if (cpid.getPortType() == CommPortIdentifier.PORT_SERIAL){
//                System.out.println("串口名：" + cpid.getName() + ",串口用户:" + cpid.getCurrentOwner());
//            }
//        }
    }

    //选择串口
    private void selectPort(String portName){
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

    //打开串口
    public void openPort(String portName){
        selectPort(portName);
        if (commPort == null){
            throw new RuntimeException("串口不存在");
        }
        try{
            serialPort = (SerialPort)commPort.open(owner, timeout);
            System.out.println("端口:"+commPort.getName()+" 已打开");
        }catch (PortInUseException e){
            throw new RuntimeException(String.format("端口'%1$s'正在使用中！",
                    commPort.getName()));
        }
    }

    /**
     * 配置串口。只有在打开串口后，才能配置串口
     * @param baudRate 波特率
     * @param dataBits 数据位
     * @param stopBits 停止位
     * @param parity 校验位
     */
    public void configSerialPortParams(int baudRate,int dataBits,int stopBits,int parity){
        try {
            serialPort.setSerialPortParams(baudRate,
                    dataBits,
                    stopBits,
                    parity);
        } catch (UnsupportedCommOperationException e) {
            e.printStackTrace();
        }
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

    //关闭串口
    public void close(){
        serialPort.close();
        serialPort = null;
        commPort = null;
    }

    public CommPortIdentifier getCommPort() {
        return commPort;
    }

    public SerialPort getSerialPort() {
        checkPort();
        return serialPort;
    }

    public String getOwner() {
        return owner;
    }

    public int getTimeout() {
        return timeout;
    }
}
