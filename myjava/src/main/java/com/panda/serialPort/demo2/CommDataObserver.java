package com.panda.serialPort.demo2;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by My on 2019/10/16.
 */
public class CommDataObserver implements Observer{
    String name;
    public CommDataObserver(String name) {
        this.name = name;
    }
    public void update(Observable o, Object arg) {
        System.out.println("[" + name + "] GetMessage:\n [" + new String((byte[]) arg) + "]");
    }
}
