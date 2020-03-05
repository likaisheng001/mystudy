package com.panda.study.designmodel_gp.builder.simple;/**
 * Created by My on 2020-03-01.
 */

import lombok.Data;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 14:59:32 2020-03-01
 * @Modified By:
 */
@Data
public class Course {
    private String name;
    private String ppt;
    private String video;
    private String note;
    private String homework;

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", ppt='" + ppt + '\'' +
                ", video='" + video + '\'' +
                ", note='" + note + '\'' +
                ", homework='" + homework + '\'' +
                '}';
    }
}
