package designmodel.template;

/**
 * Created by Administrator on 2019/9/1.
 */
public class PureSoyaMilk extends SoyaMilk{
    @Override
    void addCondiments() {
    }

    @Override
    boolean customerWantCondiments() {
        return false;
    }
}
