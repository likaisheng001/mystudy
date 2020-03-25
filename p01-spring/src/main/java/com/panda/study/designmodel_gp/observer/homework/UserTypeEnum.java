package com.panda.study.designmodel_gp.observer.homework;/**
 * Created by My on 2020-03-25.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:58:53 2020-03-25
 * @Modified By:
 */
public enum  UserTypeEnum {
    TEACHER("老师"),
    STUDENT("同学");

    private String desc;

    UserTypeEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
