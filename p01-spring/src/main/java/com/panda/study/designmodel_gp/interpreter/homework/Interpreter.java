package com.panda.study.designmodel_gp.interpreter.homework;/**
 * Created by My on 2020-03-22.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 19:11:01 2020-03-22
 * @Modified By:
 */
public abstract class Interpreter implements IArithmeticInterpreter {
    protected IArithmeticInterpreter left;
    protected IArithmeticInterpreter right;

    public Interpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        this.left = left;
        this.right = right;
    }
}
