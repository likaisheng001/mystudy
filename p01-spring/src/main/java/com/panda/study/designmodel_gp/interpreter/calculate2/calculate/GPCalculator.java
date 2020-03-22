package com.panda.study.designmodel_gp.interpreter.calculate2.calculate;/**
 * Created by My on 2020-03-22.
 */

import java.util.Stack;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 19:04:14 2020-03-22
 * @Modified By:
 */
public class GPCalculator {
    private Stack<IArithmeticInterpreter> stack = new Stack<IArithmeticInterpreter>();
    private Stack<IArithmeticInterpreter> stack2 = new Stack<IArithmeticInterpreter>();

    public GPCalculator(String expression) {
        parse(expression);
    }

    // 10 + 30
    private void parse(String expression) {
        String[] elements = expression.split(" ");
        IArithmeticInterpreter left,right;

        for (int i = 0; i < elements.length; i++) {
            String operator = elements[i];
            if (OperatorUtil.ifOperator(operator)){
                left = this.stack.pop();
                right = new NumInterpreter(Integer.valueOf(elements[++i]));
                System.out.println("出栈" + left.interpret() + "和" + right.interpret());
                this.stack.push(OperatorUtil.getInterpreter(left,right,operator));
                System.out.println("应用运算符: " + operator);
            } else if (OperatorUtil.ifLeftBracket(operator)){
                LeftBracketInterpreter leftBracketInterpreter = new LeftBracketInterpreter();
                stack.push(leftBracketInterpreter);
            } else if (OperatorUtil.ifRightBracket(operator)) {
                recall();
            } else {
                NumInterpreter numInterpreter = new NumInterpreter(Integer.valueOf(elements[i]));
                stack.push(numInterpreter);
                System.out.println("入栈: " + numInterpreter.interpret());
            }
        }
    }

    private void recall() {
        IArithmeticInterpreter pop = stack.pop();
        if (pop instanceof LeftBracketInterpreter){
            stack.push(stack2.pop());
        }else {
            stack2.push(pop);
        }
    }

    public int calculate(){
        return this.stack.pop().interpret();
    }
}
