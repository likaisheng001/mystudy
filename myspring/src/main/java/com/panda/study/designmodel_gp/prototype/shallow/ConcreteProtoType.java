package com.panda.study.designmodel_gp.prototype.shallow;/**
 * Created by My on 2020-03-01.
 */

import com.panda.study.designmodel_gp.prototype.general.IProtoType;
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

    @Override
    public ConcreteProtoType clone() {
        try {
            return (ConcreteProtoType)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
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
