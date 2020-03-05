package com.panda.study.designmodel_gp.factory.factorymethod;/**
 * Created by My on 2020-03-05.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:25:53 2020-03-05
 * @Modified By:
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        ICourseFactory factory = new PythonCourseFactory();
        ICourse course = factory.create();
        System.out.println("course:" + course);
    }
}
