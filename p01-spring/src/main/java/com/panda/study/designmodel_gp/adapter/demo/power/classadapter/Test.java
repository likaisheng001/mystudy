package com.panda.study.designmodel_gp.adapter.demo.power.classadapter;/**
 * Created by My on 2020-03-11.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:33:43 2020-03-11
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        PowerAdapter adapter = new PowerAdapter();
        adapter.output5V();
        adapter.outputAC220V(); // 违背最少知道原则
    }
}
