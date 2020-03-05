package com.panda.study.designmodel_gp.prototype.deep;/**
 * Created by My on 2020-03-01.
 */

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
public class ConcreteProtoType implements Cloneable, Serializable {

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

    public ConcreteProtoType deepCloneHobbies(){
        try {
            ConcreteProtoType concreteProtoType = (ConcreteProtoType)super.clone();
            concreteProtoType.hobbies = (ArrayList)((ArrayList) concreteProtoType.hobbies).clone();
            return concreteProtoType;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ConcreteProtoType deepClone(){
        try{
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            return (ConcreteProtoType)ois.readObject();
        }catch (Exception e){
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
