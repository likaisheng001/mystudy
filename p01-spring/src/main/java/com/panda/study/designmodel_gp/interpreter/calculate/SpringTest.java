package com.panda.study.designmodel_gp.interpreter.calculate;/**
 * Created by My on 2020-03-22.
 */

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 19:34:06 2020-03-22
 * @Modified By:
 */
public class SpringTest {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("100 * 2 + 400 * 1 + 66");
        Integer result = (Integer) expression.getValue();
        System.out.println("计算结果是：" + result);
    }
}
