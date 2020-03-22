package com.panda.study.designmodel_gp.interpreter.calculate;/**
 * Created by My on 2020-03-22.
 */

/**
 * @Author: Likaisheng
 * @Description: 终结表达式
 * @Date: Created in 19:09:40 2020-03-22
 * @Modified By:
 */
public class NumInterpreter implements IArithmeticInterpreter {
    private int value;

    public NumInterpreter(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return this.value;
    }
}
