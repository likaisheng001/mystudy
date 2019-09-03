package designmodel.mediator;

/**
 * Created by Administrator on 2019/9/2.
 */
public abstract class Mediator {
    public abstract void register(String colleagueName,Colleague colleague);
    public abstract void getMessage(int stateChange,String colleagueName);
    //这个方法有啥作业
    public abstract void sendMessage();
}
