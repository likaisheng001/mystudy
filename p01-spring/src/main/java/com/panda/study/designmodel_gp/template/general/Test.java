package com.panda.study.designmodel_gp.template.general;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        AbstractClass abc = new ConcreteClassA();
        abc.templateMehthod();
        abc = new ConcreteClassB();
        abc.templateMehthod();
    }
}
