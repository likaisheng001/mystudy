package com.panda.study.designmodel_gp.command.homework.command;/**
 * Created by My on 2020-03-18.
 */

import com.panda.study.designmodel_gp.command.homework.FTPServer;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:56:38 2020-03-18
 * @Modified By:
 */
public class FtpCommand implements ICommand {

    public FTPServer server;

    public FtpCommand(FTPServer server) {
        this.server = server;
    }

    @Override
    public void execute() {
        this.server.exec();
        System.out.println("上传选中文件");
    }
}
