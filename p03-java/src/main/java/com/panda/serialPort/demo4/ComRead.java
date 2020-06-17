/*
package com.panda.serialPort.demo4;

*/
/**
 * Created by My on 2019/10/17.
 *//*


import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

*/
/**
 *
 * @author Administrator
 *//*

public class ComRead implements Runnable{
    static CommPortIdentifier portId;
    static Enumeration portList;//枚举类
    InputStream inputStream;
    SerialPort serialPort;
    Thread readThread;
    StringToHex sHex;
    public void start(){
        portList=CommPortIdentifier.getPortIdentifiers();//利用枚举类型得到所有通信端口
        while(portList.hasMoreElements()){
            portId=(CommPortIdentifier)portList.nextElement();
            if(portId.getPortType()==CommPortIdentifier.PORT_SERIAL){//如果为串口的话
                ///System.out.println(portId.getName());
                if(portId.getName().equals("COM3")){//如果是COM3，这里需要你自己设定指定的串口
                    try{
                        //打开串口
                        serialPort=(SerialPort)portId.open("Main",2000);
                    }catch(PortInUseException e){}
                    try {
                        inputStream = serialPort.getInputStream();*/
/*获取端口的输入流对象*//*

                    } catch (IOException e) {}
                }// end if
            }// end if
        }// end while
        try{
            readThread = new Thread(this);
//线程负责每发送一次数据，休眠2秒钟
            readThread.start();
        }
        catch (Exception e) { }
    }
    public void run(){

        try{
            serialPort.setSerialPortParams(9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
        }catch (UnsupportedCommOperationException e) { }
        byte[] readB=new byte[21];
        byte[] readC=new byte[21];
        int nBytes=0;
        String Buff="";
        String Buffer="";
        try{
            while(inputStream.available()>0){
                nBytes = inputStream.read(readB);
            }
            sHex.printHexString(readB);//将读出的字符数组数据，直接转换成十六进制。
        }catch(IOException e){
            System.err.println(e.toString());
        }
        try {
            Thread.sleep(2000); //读取数据成功，继续start
        } catch (InterruptedException e) { }
        start();
    }
}*/
