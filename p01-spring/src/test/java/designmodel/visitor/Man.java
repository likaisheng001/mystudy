package designmodel.visitor;

/**
 * Created by Administrator on 2019/8/30.
 */
public class Man extends Person{

    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
