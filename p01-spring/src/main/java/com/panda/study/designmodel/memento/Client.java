package com.panda.study.designmodel.memento;

/**
 * Created by Administrator on 2019/8/6.
 */
public class Client {
    public static void main(String[] args) {
        //创建游戏角色
        GameRole gameRole = new GameRole();
        gameRole.setDef(100);
        gameRole.setVit(100);
        System.out.println("和boss大战前的状态");
        gameRole.display();
        //把当前状态保存到caretaker
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(gameRole.createMemento());
        System.out.println("和boss大战------");
        gameRole.setVit(30);
        gameRole.setDef(30);
        gameRole.display();
        System.out.println("大战后，使用备忘录对象恢复元气");
        gameRole.recoverGameRoleFromMemento(caretaker.getMemento());
        System.out.println("恢复后的状态");
        gameRole.display();
    }
}
