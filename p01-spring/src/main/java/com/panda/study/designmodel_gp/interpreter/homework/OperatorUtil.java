package com.panda.study.designmodel_gp.interpreter.homework;/**
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
        return (symbol.equals("+") || symbol.equals("-") || symbol.equals("*") ||
                symbol.equals("/") || symbol.equals("(") || symbol.equals(")"));
    }
    public static OperatorEnum getOperatorEnum(String symbol){
        if ("+".equals(symbol)){
            return OperatorEnum.ADD;
        }else if ("-".equals(symbol)){
            return OperatorEnum.SUB;
        }else if ("*".equals(symbol)){
            return OperatorEnum.MULTI;
        }else if ("/".equals(symbol)){
            return OperatorEnum.DIV;
        }else if ("(".equals(symbol)){
            return OperatorEnum.LEFT_BRACKET;
        }else if (")".equals(symbol)){
            return OperatorEnum.RIGHT_BRACKET;
        }
        return null;
    }
    public static int comparePriority(OperatorEnum e1,OperatorEnum e2){

        return e1.getPriority() - e2.getPriority();
    }

    public static Interpreter getInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right, String symbol){
        if (symbol.equals("+")){
            return new AddInterpreter(left,right);
        } else if (symbol.equals("-")){
            return new SubInterpreter(left,right);
        }else if(symbol.equals("*")){
            return new MultilInterpreter(left,right);
        } else if (symbol.equals("/")){
            return new DivInterpreter(left,right);
        } else {
            return null;
        }
    }
}
