package com.panda.tmptest.demo1;/**
 * Created by My on 2019-12-12.
 */

import com.google.zxing.client.j2se.GUIRunner;

import java.util.*;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 14:23:24 2019-12-12
 * @Modified By:
 */
public class StrategyDemo {
    public static void main(String[] args) {
        //待发送的数据，共有100w条
        List<Customer> customerList = new ArrayList<Customer>();
        //...

        //遍历待发送的数据，统计各个导购的客户数，并做成Map
        Map<String,Integer> guideMap = new HashMap<String,Integer>();
        for (int i = 0; i < customerList.size(); i++){
            String guideName = customerList.get(i).getGuideName();
            if (guideMap.containsKey(guideName)){
                guideMap.put(guideName,guideMap.get(guideName) + 1);
            }else{
                guideMap.put(guideName,1);
            }
        }

        //根据统计结果，为了优化发送策略，将导购的客户数>=10000的，选出来优先发送
        //假设，导购A（30020客户），此处的效果就是，先发送3次数据，最后将guideMap中导购A的剩余数改为20
        Iterator<Map.Entry<String, Integer>> iter = guideMap.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<String, Integer> next = iter.next();
            Integer num = next.getValue();
            String key = next.getKey();
            while (num >= 10000){
                num -= 10000;

                //开始找数据，并准备数据
                List<Customer> tmpCustomerList = new ArrayList<Customer>();
                for (int i = 0; i < customerList.size(); i++){
                    if (customerList.get(i).getGuideName().equals(key) && tmpCustomerList.size() < 10000){
                        tmpCustomerList.add(customerList.get(i));
                    }
                }
                //调用发送方法,将tmpCustomerList发送出去
                //...
                customerList.removeAll(tmpCustomerList);
            }
            guideMap.put(key,num);  //修改guideMap中该导购的剩余客户数
        }

        //经过上一步的处理后，guideMap中不存在 >= 10000个客户的导购了
        //将guideMap转成List，为了方便接下来的算法处理
        Iterator<Map.Entry<String, Integer>> iter2 = guideMap.entrySet().iterator();
        List<Guide> guideList = new ArrayList<Guide>();
        while (iter2.hasNext()){
            Map.Entry<String, Integer> next = iter2.next();
            if (next.getValue() > 0){
                guideList.add(new Guide(next.getKey(),next.getValue()));
            }
        }

        //在剩下的数据中，找看有没有 导购A(5000客户) + 导购B(5000客户) 两个可以和凑一批进行发送的情况
        for (int i = 0; i < guideList.size(); i ++){
            Guide guide = guideList.get(i);
            Integer num = guide.getNum();
            for (int j = i+1; j < guideList.size(); j++){
                if (guideList.get(j).getNum() + num == 10000){
                    //准备数据，并进行发送
                    //...
                    //数据发送后，将这两个导购从数组中删除
                }
            }
        }

        //然后再处理 3个凑一批的情况
    }
}
