package com.panda.study.designmodel_gp.interpreter.homework;/**
 * Created by My on 2020-03-22.
 */

/**
 * @Author: Likaisheng
 * @Description: 非终结表达式
 * @Date: Created in 19:12:51 2020-03-22
 * @Modified By:
 */
public class MultilInterpreter extends Interpreter {

    public MultilInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return this.left.interpret() * this.right.interpret();
    }
}
