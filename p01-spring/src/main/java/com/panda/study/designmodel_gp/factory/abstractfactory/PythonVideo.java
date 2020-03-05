package com.panda.study.designmodel_gp.factory.abstractfactory;/**
 * Created by My on 2020-03-05.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:47:44 2020-03-05
 * @Modified By:
 */
public class PythonVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("录制Python课程");
    }
}
