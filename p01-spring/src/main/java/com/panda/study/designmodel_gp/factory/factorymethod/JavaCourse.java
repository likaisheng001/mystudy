package com.panda.study.designmodel_gp.factory.factorymethod;/**
 * Created by My on 2020-03-05.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:48:12 2020-03-05
 * @Modified By:
 */
public class JavaCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("正在录制java课程");
    }
}
