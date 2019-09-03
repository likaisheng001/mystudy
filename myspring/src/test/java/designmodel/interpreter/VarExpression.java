package designmodel.interpreter;

import java.util.HashMap;

/**
 * Created by Administrator on 2019/9/2.
 */
public class VarExpression extends Expression{
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}
