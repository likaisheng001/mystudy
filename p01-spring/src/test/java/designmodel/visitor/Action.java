package designmodel.visitor;


//用来定义分离出来的操作共性
public abstract class Action {
    public abstract void getManResult(Man man);
    public abstract void getWomanResult(Woman woman);
}
