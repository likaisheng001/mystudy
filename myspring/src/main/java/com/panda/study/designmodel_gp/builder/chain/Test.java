package com.panda.study.designmodel_gp.builder.chain;/**
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
        CourseBuilder builder = new CourseBuilder()
                .addName("设计模式")
                .addPpt("PPT课件")
                .addVideo("录播视频");

        System.out.println(builder.builder());
    }
}
