package com.panda.study.designmodel_gp.factory.simplefactory;/**
 * Created by My on 2020-03-05.
 */

import org.slf4j.LoggerFactory;

import java.util.Calendar;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:48:25 2020-03-05
 * @Modified By:
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        ICourse course = new CourseFactory().create(JavaCourse.class);
        course.record();

//        Calendar instance = Calendar.getInstance();
//        LoggerFactory.getLogger();
    }
}
