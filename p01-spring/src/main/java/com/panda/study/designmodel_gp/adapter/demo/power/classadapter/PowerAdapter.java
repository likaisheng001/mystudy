package com.panda.study.designmodel_gp.adapter.demo.power.classadapter;/**
 * Created by My on 2020-03-11.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:31:57 2020-03-11
 * @Modified By:
 */
public class PowerAdapter extends AC220 implements DC5 {
    public int output5V(){
        int adapterInput = super.outputAC220V();
        int adapterOutput = adapterInput / 44;
        System.out.println("使用Adapter输入AC" + adapterInput + "V,输出DC" + adapterOutput + "V.");
        return adapterOutput;
    }
}
