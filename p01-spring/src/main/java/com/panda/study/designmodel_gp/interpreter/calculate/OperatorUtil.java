package com.panda.study.designmodel_gp.interpreter.calculate;/**
 * Created by My on 2020-03-22.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 19:18:03 2020-03-22
 * @Modified By:
 */
public class OperatorUtil {
    public static boolean ifOperator(String symbol){
        return (symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/"));
    }

    public static Interpreter getInterpreter(IArithmeticInterpreter left,IArithmeticInterpreter right,String symbol){
        if (symbol.equals("+")){
            return new AddInterpreter(left,right);
        } else if (symbol.equals("-")){
            return new SubInterpreter(left,right);
        }else if(symbol.equals("*")){
            return new MultilInterpreter(left,right);
        } else if (symbol.equals("/")){
            return new AddInterpreter(left,right);
        } else {
            return null;
        }
    }
}
