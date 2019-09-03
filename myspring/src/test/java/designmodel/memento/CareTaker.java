package designmodel.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/9/2.
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();
    public void add(Memento memento){
        mementoList.add(memento);
    }
    public Memento get(int index){
        return mementoList.get(index);
    }
}
