package com.panda.study.designmodel_gp.delegate.simple;/**
 * Created by My on 2020-03-26.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:29:14 2020-03-26
 * @Modified By:
 */
public class EmployeeB implements IEmployee {
    protected String goodAt = "平面设计";
    @Override
    public void doing(String task) {
        System.out.println("我是员工B,我擅长" + goodAt + ",现在开始做" + task + "工作");
    }
}
