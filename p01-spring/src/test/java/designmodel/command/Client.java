package designmodel.command;

/**
 * Created by Administrator on 2019/8/30.
 */
public class Client {
    public static void main(String[] args) {

        LightReceiver lightReceiver = new LightReceiver();
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);
        RemoteController remoteController = new RemoteController();
        //给我们的遥控器设置相关命令,比如no=0是电灯的开和关的操作
        remoteController.setCommand(0,lightOnCommand,lightOffCommand);
        System.out.println("-------------按下灯的开按钮------------");
        remoteController.onButtonWasPushed(0);
        System.out.println("-------------按下灯的关按钮------------");
        remoteController.offButtonWasPushed(0);
        System.out.println("-------------按下灯的撤销按钮------------");
        remoteController.undoButtonWasPush();

        System.out.println("===========使用遥控器操作电视剧=============");
        TVReceiver tvReceiver = new TVReceiver();
        TVOffCommand tvOffCommand = new TVOffCommand(tvReceiver);
        TVOnCommand tvOnCommand = new TVOnCommand(tvReceiver);
        remoteController.setCommand(1,tvOnCommand,tvOffCommand);
        System.out.println("-------------按下电视机的开按钮------------");
        remoteController.onButtonWasPushed(1);
        System.out.println("-------------按下电视机的关按钮------------");
        remoteController.offButtonWasPushed(1);
        System.out.println("-------------按下灯的撤销按钮------------");
        remoteController.undoButtonWasPush();
    }
}
