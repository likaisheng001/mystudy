package designmodel.interpreter;

import java.util.HashMap;

//解释器模板的定义
public abstract class Expression {
    //为什么传入的个map作为参数
    public abstract int interpreter(HashMap<String,Integer> var);
}
