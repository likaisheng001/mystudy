package com.panda.study.designmodel_gp.observer.gper;/**
 * Created by My on 2020-03-24.
 */


import com.panda.study.designmodel_gp.interpreter.homework.GPAdvancedCalculator;

import java.util.Observable;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 14:59:30 2020-03-24
 * @Modified By:
 */
public class GPer extends Observable {
    private String name = "GPer生态圈";
    private static final GPer gper = new GPer();

    private GPer() {
    }
    public static GPer getInstance(){
        return gper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void publishQuestion(Question question){
        System.out.println(question.getUserName() + "在" + this.name + "上提交了一个问题。");
        setChanged();
        notifyObservers(question);
    }
}
