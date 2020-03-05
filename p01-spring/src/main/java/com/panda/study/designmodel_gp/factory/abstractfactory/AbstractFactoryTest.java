package com.panda.study.designmodel_gp.factory.abstractfactory;/**
 * Created by My on 2020-03-05.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:51:54 2020-03-05
 * @Modified By:
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        CourseFactory factory = new JavaCourseFactory();
        factory.createNote().edit();
        factory.createVideo().record();
    }
}
