package com.panda.study.designmodel_gp.builder.simple;/**
 * Created by My on 2020-03-01.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:04:25 2020-03-01
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        CourseBuilder builder = new CourseBuilder();
        builder.addName("设计模式");
        builder.addPpt("PPT课件");
        builder.addVideo("录播视频");

        System.out.println(builder.builder());
    }
}
