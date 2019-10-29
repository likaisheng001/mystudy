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

}
