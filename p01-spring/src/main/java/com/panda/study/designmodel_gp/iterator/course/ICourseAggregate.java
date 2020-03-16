package com.panda.study.designmodel_gp.iterator.course;/**
 * Created by My on 2020-03-16.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 20:47:58 2020-03-16
 * @Modified By:
 */
public interface ICourseAggregate {
    void add(Course course);
    void remove(Course course);
    Iterator<Course> iterator();
}
