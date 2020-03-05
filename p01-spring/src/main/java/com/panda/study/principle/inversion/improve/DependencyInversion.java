package com.panda.study.principle.inversion.improve;

/**
 * Created by Administrator on 2019/7/25.
 */
public class DependencyInversion {
    public static void main(String[] args) {
        //客户端无需改变
        Person person = new Person();
        person.receive(new Email());
        person.receive(new WeiXin());
    }
}
//定义接口
interface IReceiver{
    public String getInfo();
}
class WeiXin implements IReceiver{

    @Override
    public String getInfo() {
        return "微信消息：Hello ok";
    }
}
class Email implements IReceiver{
    public String getInfo(){
        return "电子邮件信息：hello world";
    }
}

class Person{
    //这里我们是对接口的依赖
    public void receive(IReceiver receiver){
        System.out.println(receiver.getInfo());
    }
}
