package com.panda.study.designmodel_gp.composite.demo.transparent;/**
 * Created by My on 2020-03-11.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 08:00:14 2020-03-11
 * @Modified By:
 */
public class CoursePackage extends CourseComponent {
    private List<CourseComponent> items = new ArrayList<CourseComponent>();
    private String name;
    private Integer level;

    public CoursePackage(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void addChild(CourseComponent component) {
        items.add(component);
    }

    @Override
    public void removeChild(CourseComponent component) {
        items.remove(component);
    }

    @Override
    public String getName(CourseComponent component) {
        return this.name;
    }

    @Override
    public void print() {
        System.out.println(this.name);
        for (CourseComponent component : items){
            if (this.level != null){
                for (int i = 0; i < this.level; i++) {
                    System.out.print("    ");
                }
                for (int i = 0; i < this.level; i++) {
                    if (i == 0){
                        System.out.print("+");
                    }
                    System.out.print("-");
                }
            }
            component.print();
        }
    }
}
