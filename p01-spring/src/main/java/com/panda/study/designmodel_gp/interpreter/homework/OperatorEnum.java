package com.panda.study.designmodel_gp.interpreter.homework;/**
 * Created by My on 2020-03-23.
 */

import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

/**
 * @Author: Likaisheng
 * @Description: 操作符枚举
 * @Date: Created in 16:04:33 2020-03-23
 * @Modified By:
 */
public enum  OperatorEnum {
    // 猜测LEFT_BRACKET是枚举的名称key,("(",3)是枚举的value,这个value是个数组或集合
    LEFT_BRACKET("(",3),
    RIGHT_BRACKET(")",3),
    ADD("+",1),
    SUB("-",1),
    // 用来简化null的处理
    DEFAULT("null",0),
    MULTI("*",2),
    DIV("/",2);

    private String operator;
    private int priority;

    public String getOperator() {
        return operator;
    }

    OperatorEnum(String operator,int priority) {
        this.operator = operator;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
