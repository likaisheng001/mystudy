package com.panda.study.designmodel_gp.observer.guava;/**
 * Created by My on 2020-03-24.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:22:22 2020-03-24
 * @Modified By:
 */
public class Pojo {
    private String name;

    public Pojo(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "name='" + name + '\'' +
                '}';
    }
}
