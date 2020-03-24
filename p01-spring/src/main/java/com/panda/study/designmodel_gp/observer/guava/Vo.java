package com.panda.study.designmodel_gp.observer.guava;/**
 * Created by My on 2020-03-24.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:24:44 2020-03-24
 * @Modified By:
 */
public class Vo {
    private String name;

    public Vo(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vo{" +
                "name='" + name + '\'' +
                '}';
    }
}
