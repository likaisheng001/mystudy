package com.panda.study.designmodel_gp.prototype.singleton;/**
 * Created by My on 2020-03-01.
 */

import lombok.Data;

import java.util.List;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:39:09 2020-03-01
 * @Modified By:
 */
@Data
public class ConcreteProtoType implements Cloneable {

    private int age;
    private String name;
    private List<String> hobbies;

    private static ConcreteProtoType instance = new ConcreteProtoType();
    private ConcreteProtoType(){}

    public static ConcreteProtoType getInstance(){
        return instance;
    }

    @Override
    public ConcreteProtoType clone() {
       return instance;
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
