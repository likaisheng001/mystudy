package com.panda.serialPort.syncData;

import java.io.UnsupportedEncodingException;

/**
 * @Author: Likaisheng
 * @Description: 已经实现电脑和串口连通，并进行正常读取。 但读取时，存在中文乱码问题，未解决
 * @Date: Created in 15:38 2019/10/17
 * @Modified By:
 */
public class SerialPortTest {
    public static void main(String[] args) throws UnsupportedEncodingException {


        /*//将串口的配置参数外提：端口号，波特率
        RS232SerialPort sp = new RS232SerialPort();
        sp.listPorts();
        sp.selectPort("COM5");

        //模拟向地磅发送数据
        //sp.write("java: hello serial port!");
        sp.startRead(120);
        sp.write(WeighBridgeCommandEnum.A.getCommand());*/
        //写个方法，将字符串转成十六进制

        //字符串预处理
        byte[] bytes = RS232SerialPort.hexStringToBytes(WeighBridgeCommandEnum.A.getCommand());

    }
}
//地磅命令
enum WeighBridgeCommandEnum{
    A("024141303003","握手"),
    B("024142303303","读毛重"),
    C("024143303203","读皮重"),
    D("024144303503","读净重"),
    E("024145303403","读车号"),
    F("024146303703","读货号");
    private String command;
    private String desc;

    WeighBridgeCommandEnum(String command,String desc) {
        this.command = command;
        this.desc = desc;
    }

    public String getCommand() {
        return command;
    }
    public String getDesc() {
        return desc;
    }

}

