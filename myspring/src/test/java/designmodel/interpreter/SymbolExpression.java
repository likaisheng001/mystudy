package designmodel.interpreter;

import java.util.HashMap;

/**
 * Created by Administrator on 2019/9/2.
 */
public class SymbolExpression extends Expression{
    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    //此处留给子类实现
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return 0;
    }
}
