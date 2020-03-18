package com.panda.study.designmodel_gp.command.homework.command;/**
 * Created by My on 2020-03-18.
 */

import com.panda.study.designmodel_gp.command.homework.FTPServer;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:28:43 2020-03-18
 * @Modified By:
 */
public class DirCommand implements ICommand{
    public FTPServer server;

    public DirCommand(FTPServer server) {
       this.server = server;
    }

    /**
     * 命令需要执行的所有逻辑，都放在命令里；
     * Server端只起调用执行的作用，类似于CPU
     */
    @Override
    public void execute() {
        this.server.exec();
        System.out.println("列出当前目录下所有文件");
    }
}
