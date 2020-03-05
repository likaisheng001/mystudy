package com.panda.study.designmodel_gp.factory.factorymethod;/**
 * Created by My on 2020-03-05.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:25:23 2020-03-05
 * @Modified By:
 */
public class PythonCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
