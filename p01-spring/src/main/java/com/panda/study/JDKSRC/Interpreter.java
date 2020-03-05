package com.panda.study.JDKSRC;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Created by Administrator on 2019/8/6.
 */
public class Interpreter {
    public static void main(String[] args) {
        //创建一个Parser对象
        SpelExpressionParser parser = new SpelExpressionParser();
        //通过Parser对象获取到一个Expression对象
        //会根据不同的Parser对象，返回不同的
        Expression expression = parser.parseExpression("10*(2+1)*1+66");
        int result = (Integer) expression.getValue();
        System.out.println(result);
    }
}
