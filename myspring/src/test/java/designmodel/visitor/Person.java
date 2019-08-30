package designmodel.visitor;

//用来定义抽取出来的数据部分
public abstract class Person {
    public abstract void accept(Action action);
}
