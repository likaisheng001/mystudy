package designmodel.memento;

/**
 * Created by Administrator on 2019/9/2.
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("状态#1 攻击力100");
        careTaker.add(originator.saveStateMenento());
        originator.setState("状态#2 攻击力80");
        careTaker.add(originator.saveStateMenento());
        originator.setState("状态#3 攻击力50");
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("恢复到状态1，当前的状态="+originator.getState());
    }
}
