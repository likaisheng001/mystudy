package com.panda.pattern.delegate.simple;/**
 * Created by My on 2019-12-09.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 19:57:23 2019-12-09
 * @Modified By:
 */
public class EmployeeB implements IEmployee{
    @Override
    public void doing(String command) {
        System.out.println("我是员工B，我开始干活了");
    }
}
