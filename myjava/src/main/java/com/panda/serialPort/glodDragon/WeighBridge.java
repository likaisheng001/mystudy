package com.panda.serialPort.glodDragon;/**
 * Created by My on 2019/10/23.
 */

import java.util.LinkedList;

/**
 * @Author: Likaisheng
 * @Description: 用于管理地磅对接
 * @Date: Created in 14:36 2019/10/23
 * @Modified By:
 */
public class WeighBridge {
    private RS232SerialPort serialPort;
    private WeighBridgeInterpreter interpreter;

    public WeighBridge() {
        this.serialPort = new RS232SerialPort("write");
        this.interpreter = new WeighBridgeInterpreter();
    }

    public void connect(String portName,String owner){
        serialPort.selectPort(portName);
        serialPort.openPort();
    }

    public void startRead(int time){
       serialPort.startRead(time);
    }

    public void write(String message){
        serialPort.write(WeighBridgeUtil.hexStringToBytes(message));
    }

    public LinkedList<Byte> getResult(){
        return RS232SerialPort.getRECEIVEBYTES();
    }
}
