package com.panda.study.designmodel_gp.prototype.singleton;/**
 * Created by My on 2020-03-01.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:48:53 2020-03-01
 * @Modified By:
 */
public class Client {
    public static void main(String[] args) {
        ConcreteProtoType concreteProtoType = ConcreteProtoType.getInstance();
        concreteProtoType.setAge(20);
        concreteProtoType.setName("Vulcan");
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("书法");
        hobbies.add("音乐");

        concreteProtoType.setHobbies(hobbies);

        //拷贝原型对象
        ConcreteProtoType cloneType = concreteProtoType.clone();
        cloneType.getHobbies().add("技术控");

        System.out.println("原型对象：" + concreteProtoType);
        System.out.println("克隆对象：" + cloneType);
        System.out.println(concreteProtoType == cloneType);


        System.out.println("原型对象的爱好：" + concreteProtoType.getHobbies());
        System.out.println("克隆对象的爱好：" + cloneType.getHobbies());
        System.out.println(concreteProtoType.getHobbies() == cloneType.getHobbies());

    }
}
