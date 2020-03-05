package designmodel.memento.theory;

import java.util.ArrayList;
import java.util.HashMap;

//守护者对象，保持游戏角色的状态
//支持保存多个角色，多个状态
public class Caretaker {
//    private Memento memento;
    //多role保存多次状态
//    private ArrayList<Memento> mementos;
    private HashMap<String,ArrayList<Memento>> mementoMap;

    public Caretaker() {
        this.mementoMap = new HashMap<String,ArrayList<Memento>>();
    }

    public Memento getMemento(String roleName, int idx){
        return mementoMap.get(roleName).get(idx);
    }
    public void setMemento(String roleName,Memento memento){
        if (!mementoMap.containsKey(roleName)){
            mementoMap.put(roleName,new ArrayList<Memento>());
        }
        mementoMap.get(roleName).add(memento);
    }
}
