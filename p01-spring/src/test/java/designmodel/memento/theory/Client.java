package designmodel.memento.theory;

/**
 * Created by Administrator on 2019/9/3.
 */
public class Client {
    public static void main(String[] args) {
        GameRole role1 = new GameRole();
        role1.setDef(100);
        role1.setVit(100);
        System.out.println("和boss大战前的状态");
        role1.display();
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento("role1",role1.createMemento());
        System.out.println("和boss大战 - - - ");
        role1.setVit(30);
        role1.setDef(30);
        role1.display();
        System.out.println("大战后，使用备忘录对象恢复元气");
        role1.recoverGameRoleFromMemento(caretaker.getMemento("role1",0));
        System.out.println("恢复后的状态");
        role1.display();
    }
}
