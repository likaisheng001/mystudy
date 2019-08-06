package com.panda.study.designmodel.memento;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2019/8/6.
 */
//守护者对象，保持游戏角色的状态
public class Caretaker {
    //如果只保存一次状态
    private Memento memento;
//    //对GameRole保存多次状态
//    private ArrayList<Memento> mementos;
//    //对多个游戏角色保存多个状态
//    private HashMap<String,ArrayList<Memento>> roleMementos;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
