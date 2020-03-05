package com.panda.study.designmodel.visitor;

import java.util.LinkedList;
import java.util.List;

//数据结构：管理很多人(Man,Woman)
public class ObjectStructure {
    //维护了一个集合
    private List<Person> persons = new LinkedList<Person>();
    //增加到List
    public void attach(Person p){
        persons.add(p);
    }
    //移除
    public void detach(Person p){
        persons.remove(p);
    }
    //显示评测情况
    public void display(Action action){
        for (Person p:persons) {
            p.accept(action);
        }
    }
}
