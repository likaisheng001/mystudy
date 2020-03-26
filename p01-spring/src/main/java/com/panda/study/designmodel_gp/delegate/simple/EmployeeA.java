package com.panda.study.designmodel_gp.delegate.simple;/**
 * Created by My on 2020-03-26.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:28:58 2020-03-26
 * @Modified By:
 */
public class EmployeeA implements IEmployee {
    protected String goodAt = "编程";
    @Override
    public void doing(String task) {
        System.out.println("我是员工A,我擅长" + goodAt + ",现在开始做" + task + "工作");
    }
}
