package com.panda.study.designmodel_gp.interpreter.homework;/**
 * Created by My on 2020-03-23.
 */

import java.util.Stack;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:21:22 2020-03-23
 * @Modified By:
 */
public class GPAdvancedCalculator {
    // 数栈
    private Stack<IArithmeticInterpreter> numStack = new Stack<IArithmeticInterpreter>();
    // 符号栈
    private Stack<OperatorEnum> symbolStack = new Stack<OperatorEnum>();

    public GPAdvancedCalculator(String expression){
        this.parse(expression);
    }

    private void parse(String expression) {
        String[] elements = expression.split(" ");
        // 在解析表达式的时候，如何处理运算符的优先级和括号
        // 1. 当解析到操作符时，判断该操作符与符号栈顶的操作符
        // 2. 若当前操作符的优先级大，则直接压入符号栈
        // 3. 若当前操作符的优先级小，则弹出符号栈顶的元素和数栈顶的前2个元素，进行计算，将结果入栈
        for (int i = 0; i < elements.length; i++) {
            String e = elements[i];
            if (OperatorUtil.ifOperator(e)){
                OperatorEnum curOperator = OperatorUtil.getOperatorEnum(e);

                // ")" 如果是右括号要特别处理
                if (curOperator == OperatorEnum.RIGHT_BRACKET){
                    parseParcket();
                    continue;
                }

                // 这一段处理null的逻辑，本是简化程序，反倒使程序复杂了
                OperatorEnum preOperator = OperatorEnum.DEFAULT;
                if (!symbolStack.empty()){
                    preOperator = symbolStack.pop();
                }

                if (OperatorUtil.comparePriority(curOperator,preOperator) > 0){
                    if (preOperator != OperatorEnum.DEFAULT){
                        symbolStack.push(preOperator);
                    }
                    symbolStack.push(curOperator);
                } else {
                    if (preOperator == OperatorEnum.LEFT_BRACKET){
                        symbolStack.push(preOperator);
                    } else {
                        IArithmeticInterpreter right = numStack.pop();
                        IArithmeticInterpreter left = numStack.pop();
                        Interpreter interpreter = OperatorUtil.getInterpreter(left, right, preOperator.getOperator());
                        numStack.push(new NumInterpreter(interpreter.interpret()));
                    }
                    symbolStack.push(curOperator);
                }
            } else {
                numStack.push(new NumInterpreter(Integer.valueOf(e)));
            }
        }
    }

    /**
     * 在解析表达式时，遇到右括号，需要特别处理
     */
    private void parseParcket() {
        OperatorEnum operator = symbolStack.pop();
        if (operator == OperatorEnum.LEFT_BRACKET){
            return;
        }
        IArithmeticInterpreter right = numStack.pop();
        IArithmeticInterpreter left = numStack.pop();

        Interpreter interpreter = OperatorUtil.getInterpreter(left, right, operator.getOperator());
        numStack.push(new NumInterpreter(interpreter.interpret()));
        parseParcket();
    }

    public int calculate(){
        while (!symbolStack.empty()){
            OperatorEnum operatorEnum = symbolStack.pop();
            IArithmeticInterpreter right = numStack.pop();
            IArithmeticInterpreter left = numStack.pop();
            Interpreter interpreter = OperatorUtil.getInterpreter(left, right, operatorEnum.getOperator());
            numStack.push(new NumInterpreter(interpreter.interpret()));
        }
        return numStack.pop().interpret();
    }
}
