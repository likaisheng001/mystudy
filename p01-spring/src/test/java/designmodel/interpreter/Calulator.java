package designmodel.interpreter;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Administrator on 2019/9/3.
 */
public class Calulator {
    private Expression expression;//相当于语法树的根节点

    public Calulator(String expStr) {
        //使用栈来处理运算的先后顺序
        Stack<Expression> stack = new Stack<Expression>();
        char[] charArray = expStr.toCharArray();

        Expression left = null;
        Expression right = null;

        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]){
                case '+':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left,right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left,right));
                    break;
                default:
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
            }
        }
        this.expression = stack.pop();
    }
    public int run(HashMap<String,Integer> var){
        return this.expression.interpreter(var);
    }
}
