package com.panda.tmptest;/**
 * Created by My on 2019-12-12.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 13:33:44 2019-12-12
 * @Modified By:
 */
public class Person implements Comparable<Person>{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {

        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
