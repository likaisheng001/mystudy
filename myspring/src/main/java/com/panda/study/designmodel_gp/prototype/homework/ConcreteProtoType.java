package com.panda.study.designmodel_gp.prototype.homework;/**
 * Created by My on 2020-03-01.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:39:09 2020-03-01
 * @Modified By:
 */
@Data
public class ConcreteProtoType {

    private int age;
    private String name;
    private List<String> hobbies;

    public ConcreteProtoType deepClone(){
        String jsonStr = JSON.toJSONString(this);
        return JSON.parseObject(jsonStr, ConcreteProtoType.class);
    }

    @Override
    public String toString() {
        return "ConcreteProtoType{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}
