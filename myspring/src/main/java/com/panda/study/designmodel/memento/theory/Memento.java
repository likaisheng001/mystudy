package com.panda.study.designmodel.memento.theory;

/**
 * Created by Administrator on 2019/8/6.
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
