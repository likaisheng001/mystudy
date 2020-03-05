package designmodel.visitor;

/**
 * Created by Administrator on 2019/8/30.
 */
public class Woman extends Person{
    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
