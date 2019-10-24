package com.panda.serialPort.glodDragon;/**
 * Created by My on 2019/10/23.
 */

import com.panda.serialPort.syncData.*;
import com.panda.serialPort.syncData.RS232SerialPort;

import java.util.*;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:01 2019/10/23
 * @Modified By:
 */
public class WeighBridgeTest {
    public static void main(String[] args) throws InterruptedException {
        WeighBridge weighBridge = new WeighBridge();
        weighBridge.connect("COM5","金龙");
        //思考一下，能否用生产者消费者模式来处理交互
        weighBridge.write(WeighBridgeCommandEnum.A.getCommand());
        //weighBridge.write(WeighBridgeCommandEnum.D.getCommand());
        Thread.sleep(1000);

//        LinkedList<Byte> receivebytes = weighBridge.getResult();
//        //取数据以2和3为标志来取数据
//        HashMap<Integer, List<Byte>> commandMap = new HashMap<Integer, List<Byte>>();
//        int idx = 1;
//        for (int i = 0; i < receivebytes.size(); i++) {
//            if (receivebytes.get(i) == 2){
//                commandMap.put(idx,new LinkedList<Byte>());
//            }else if (receivebytes.get(i) == 3){
//                idx ++;
//            }else{
//                commandMap.get(idx).add(receivebytes.get(i));
//            }
//        }
//        Iterator<Map.Entry<Integer, List<Byte>>> iterator = commandMap.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<Integer, List<Byte>> next = iterator.next();
//            List<Byte> value = next.getValue();
//            System.out.println(value);
//        }
//        //进行校验
//        List<Byte> bytes = commandMap.get(1);
//        for (int i = 0; i < bytes.size(); i++) {
//
//        }
//        List<Byte> bytes1 = commandMap.get(2);
//        //处理小数点
//        //获取实际数据 如何处理小数点
//        LinkedList<Byte> list = new LinkedList<Byte>();
//        for (int i = 3; i < bytes1.size()-2; i++) {
//            byte t1 = 48;
//            Byte tmp = (byte)(bytes1.get(i) - t1);
//            list.add(tmp);
//        }
//        String dataStr = "";
//        String pointStr = "";
//        for (int i = list.size()-2; i < list.size(); i++) {
//            pointStr += list.get(i);
//        }
//        int pointIdx = list.size() - 2 - Integer.parseInt(pointStr);
//
//        for (int i = 0; i < list.size()-2; i++) {
//            dataStr += list.get(i);
//            if (i == pointIdx){
//                dataStr += ".";
//            }
//        }
//        System.out.println("dataStr:"+dataStr);
//        System.out.println("pointStr="+pointStr);
//        System.out.println("重量为 = "+Float.parseFloat(dataStr) + "千克");
    }
}
