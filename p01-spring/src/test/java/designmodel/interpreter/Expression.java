package designmodel.interpreter;

import java.util.HashMap;

//解释器模式，是如何通过语法树来解释表达式的
//定义抽象解释器
public abstract class Expression {
    public abstract int interpreter(HashMap<String,Integer> var);
}
