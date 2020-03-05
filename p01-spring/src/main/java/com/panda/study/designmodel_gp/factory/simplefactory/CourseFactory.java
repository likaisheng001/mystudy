package com.panda.study.designmodel_gp.factory.simplefactory;/**
 * Created by My on 2020-03-05.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 12:03:18 2020-03-05
 * @Modified By:
 */
public class CourseFactory {
    public ICourse create(Class<? extends ICourse> clazz){
//        if ("java".equals(name)){
//            return new JavaCourse();
//        }else if ("python".equals(name)){
//            return new PythonCourse();
//        }else {
//            return null;
//        }

//        try {
//            if (!(null == className || "".equals(className))){
//                return (ICourse)Class.forName(className).newInstance();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;

        try {
            if (null != clazz){
                return (ICourse) clazz.newInstance();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
