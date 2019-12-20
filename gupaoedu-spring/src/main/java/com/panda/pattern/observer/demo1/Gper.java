package com.panda.pattern.observer.demo1;/**
 * Created by My on 2019-12-11.
 */

import java.util.Observable;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 09:46:59 2019-12-11
 * @Modified By:
 */
public class Gper extends Observable{
    private String name = "Gper生态圈";
    private static Gper gper = null;
    private Gper(){}

    public static Gper getInstance(){
        if (null == gper){
            gper = new Gper();
        }
        return gper;
    }
    public String getName(){
        return name;
    }
    public void publishQuestion(Question question){
        System.out.println(question.getUserName() + "在" + this.name + "上提交了一个问题。");
        setChanged();
        notifyObservers(question);
    }
}
