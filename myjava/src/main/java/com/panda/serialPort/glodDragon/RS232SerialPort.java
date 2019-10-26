package com.panda.serialPort.glodDragon;

import java.io.IOException;

public class RS232SerialPort{
    private SerialPortBase serialPortBase;
    private SerialPortComm serialPortComm;

    public void initSerialPort(int baudRate,int dataBits,int stopBits,int parity,String portName,String owner){
        serialPortBase = new SerialPortBase(owner);
        serialPortBase.openPort(portName);
        serialPortBase.configSerialPortParams(baudRate, dataBits,stopBits,parity);

        serialPortComm = new SerialPortComm(serialPortBase.getSerialPort());
    }

    public byte[] read(int timeout){
        byte[] bytes = null;
        try {
            bytes = serialPortComm.read(timeout);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return bytes;
    }

    public void  asyRead(){
       serialPortComm.syncRead();
    }

    public void write(byte[] bytes){
        try {
            serialPortComm.write(bytes);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    //检验
    public void verify(){
        byte[] buf = read(20000);
        byte b = buf[0];
        for (int i = 1; i < buf.length-2; i++) {
            b = (byte)(b ^ buf[i]);
        }
        System.out.println("输出校验位:"+b);
    }
    //解析
    public void interpret(){
        //解析地址、解析命令、解析数据
    }
}
