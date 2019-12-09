package com.panda.pattern.delegate.simple;/**
 * Created by My on 2019-12-09.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 19:52:34 2019-12-09
 * @Modified By:
 */
public class EmployeeA implements IEmployee{
    @Override
    public void doing(String command) {
        System.out.println("我是员工A,我开始干活了，擅长加密，执行" + command);
    }
}
