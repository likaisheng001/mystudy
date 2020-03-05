package com.panda.study.designmodel_gp.builder.simple;/**
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
    public void addName(String name){
        course.setName(name);
    }
    public void addHomework(String homework){
        course.setHomework(homework);
    }
    public void addVideo(String video){
        course.setVideo(video);
    }
    public void addNote(String note){
        course.setNote(note);
    }
    public void addPpt(String ppt){
        course.setPpt(ppt);
    }
    public Course builder(){
        return course;
    }

}
