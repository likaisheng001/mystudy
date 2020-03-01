package com.panda.study.designmodel_gp.prototype.general;/**
 * Created by My on 2020-03-01.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:39:09 2020-03-01
 * @Modified By:
 */
public class ConcreteProtoType implements IProtoType {

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ConcreteProtoType{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public ConcreteProtoType clone() {
        ConcreteProtoType concreteProtoType = new ConcreteProtoType();
        concreteProtoType.setAge(this.age);
        concreteProtoType.setName(this.name);
        return concreteProtoType;
    }
}
