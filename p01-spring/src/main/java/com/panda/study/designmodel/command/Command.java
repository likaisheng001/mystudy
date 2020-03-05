package com.panda.study.designmodel.command;

/**
 * Created by Administrator on 2019/8/4.
 */
//创建命令接口
public interface Command {
    //执行动作(操作)
    public void execute();
    //撤销动作(操作)
    public void undo();
}
