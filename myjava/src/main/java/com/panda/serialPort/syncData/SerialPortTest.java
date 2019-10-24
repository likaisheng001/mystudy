package com.panda.serialPort.syncData;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @Author: Likaisheng
 * @Description: 已经实现电脑和串口连通，并进行正常读取。 但读取时，存在中文乱码问题，未解决
 * @Date: Created in 15:38 2019/10/17
 * @Modified By:
 */
public class SerialPortTest {
    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
        //此处可以做两个线程池，来保存输入流或输出流

        //将串口的配置参数外提：端口号，波特率
        RS232SerialPort sp = new RS232SerialPort();

        sp.selectPort("COM5");

        //模拟向地磅发送数据
        //sp.write("java: hello serial port!");
        sp.startRead(120);
        //使用生产者消费者模式来控制读写
        sp.write(WeighBridgeCommandEnum.A.getCommand());
        sp.write(WeighBridgeCommandEnum.D.getCommand());
        Thread.sleep(1000);
        System.out.println(RS232SerialPort.getRECEIVEBYTES());
        LinkedList<Byte> receivebytes = RS232SerialPort.getRECEIVEBYTES();
        //取数据以2和3为标志来取数据
        HashMap<Integer, List<Byte>> commandMap = new HashMap<Integer, List<Byte>>();
        int idx = 1;
        for (int i = 0; i < receivebytes.size(); i++) {
            if (receivebytes.get(i) == 2){
                commandMap.put(idx,new LinkedList<Byte>());
            }else if (receivebytes.get(i) == 3){
                idx ++;
            }else{
                commandMap.get(idx).add(receivebytes.get(i));
            }
        }
        Iterator<Map.Entry<Integer, List<Byte>>> iterator = commandMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, List<Byte>> next = iterator.next();
            List<Byte> value = next.getValue();
            System.out.println(value);
        }
        //进行校验
        List<Byte> bytes = commandMap.get(1);
        for (int i = 0; i < bytes.size(); i++) {

        }
        List<Byte> bytes1 = commandMap.get(2);
        //处理小数点
        //获取实际数据 如何处理小数点
        LinkedList<Character> list = new LinkedList<Character>();
        for (int i = 3; i < bytes1.size()-2; i++) {

        }
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

