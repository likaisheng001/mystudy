package com.panda.study.designmodel_gp.factory.abstractfactory;/**
 * Created by My on 2020-03-05.
 */


/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:51:17 2020-03-05
 * @Modified By:
 */
public class PythonCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("正在录制python课程");
    }
}
