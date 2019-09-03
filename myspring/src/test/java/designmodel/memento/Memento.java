package designmodel.memento;

//备忘录对象 -- 抽取目标对象需要保持的数据
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
