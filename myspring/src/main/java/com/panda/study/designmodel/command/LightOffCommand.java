package com.panda.study.designmodel.command;

/**
 * Created by Administrator on 2019/8/4.
 */
public class LightOffCommand implements Command{
    //聚合LightReceiver
    LightReceiver light;
    //构造器
    public LightOffCommand(LightReceiver light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
