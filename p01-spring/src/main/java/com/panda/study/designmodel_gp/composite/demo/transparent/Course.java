package com.panda.study.designmodel_gp.composite.demo.transparent;/**
 * Created by My on 2020-03-11.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 08:00:41 2020-03-11
 * @Modified By:
 */
public class Course extends CourseComponent {
    private String name;
    private double price;

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(CourseComponent component) {
        return this.name;
    }

    @Override
    public double getPrice(CourseComponent component) {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println(name + "(￥" + price + ")");
    }
}
