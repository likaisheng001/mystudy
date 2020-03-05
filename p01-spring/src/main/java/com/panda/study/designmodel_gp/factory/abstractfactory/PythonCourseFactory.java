package com.panda.study.designmodel_gp.factory.abstractfactory;/**
 * Created by My on 2020-03-05.
 */


/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:49:02 2020-03-05
 * @Modified By:
 */
public class PythonCourseFactory extends CourseFactory {
    @Override
    protected INote createNote() {
        super.init();
        return new PythonNote();
    }

    @Override
    protected IVideo createVideo() {
        super.init();
        return new PythonVideo();
    }
}
