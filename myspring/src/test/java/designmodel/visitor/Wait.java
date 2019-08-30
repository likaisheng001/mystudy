package designmodel.visitor;

/**
 * Created by Administrator on 2019/8/30.
 */
public class Wait extends Action{

    @Override
    public void getManResult(Man man) {
        System.out.println("男人给的评价该歌手待定");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女人给的评价该歌手待定");
    }
}
