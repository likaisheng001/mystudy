package com.panda.study.designmodel_gp.builder.chain;/**
 * Created by My on 2020-03-01.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:01:05 2020-03-01
 * @Modified By:
 */
public class CourseBuilder {
    private Course course = new Course();
    public CourseBuilder addName(String name){
        course.setName(name);
        return this;
    }
    public CourseBuilder addHomework(String homework){
        course.setHomework(homework);
        return this;
    }
    public CourseBuilder addVideo(String video){
        course.setVideo(video);
        return this;
    }
    public CourseBuilder addNote(String note){
        course.setNote(note);
        return this;
    }
    public CourseBuilder addPpt(String ppt){
        course.setPpt(ppt);
        return this;
    }
    public Course builder(){
        return course;
    }

}
