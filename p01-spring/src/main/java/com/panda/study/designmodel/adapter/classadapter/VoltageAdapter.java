package com.panda.study.designmodel.adapter.classadapter;

/**
 * Created by Administrator on 2019/7/29.
 */
//适配器类
public class VoltageAdapter extends Voltage220V implements Voltage5V{
    @Override
    public int output5V() {
        //获取到220V电压
        int srcV = output220V();
        //转成5V
        int dstV = srcV / 44;
        return dstV;
    }
}
