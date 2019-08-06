package com.panda.study.designmodel.memento.theory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/8/6.
 */
public class Caretaker {
    //在List集合中会有很多的备忘录对象
    private List<Memento> mementoList = new ArrayList<Memento>();
    public void add(Memento memento){
        mementoList.add(memento);
    }
    //获取到第index个Originator的备忘录对象(即保持状态)
    public Memento get(int index){
        return mementoList.get(index);
    }
}
