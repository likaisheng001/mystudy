package com.panda.study.designmodel_gp.template.course;/**
 * Created by My on 2020-03-26.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 20:05:24 2020-03-26
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("--------------架构师课程----------------");
        JavaCourse javaCourse = new JavaCourse();
        javaCourse.setNeedCheckHomework(false);
        javaCourse.createCourse();

        System.out.println("--------------Python课程----------------");
        PythonCourse pythonCourse = new PythonCourse();
        pythonCourse.createCourse();
    }
}
