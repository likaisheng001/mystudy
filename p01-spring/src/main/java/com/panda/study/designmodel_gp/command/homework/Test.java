package com.panda.study.designmodel_gp.command.homework;/**
 * Created by My on 2020-03-18.
 */

import com.panda.study.designmodel_gp.command.homework.command.DirCommand;
import com.panda.study.designmodel_gp.command.homework.command.FtpCommand;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:26:46 2020-03-18
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        //2、用命令模式实现一个自定义的FTP服务器架构（不需要完成具体功能，但命令可以无限扩展）。
        // 为了支持命令的无效扩展，则所有命令的执行逻辑都应该放在命令里，receiver就只管执行

        FTPClient client = new FTPClient();
        FTPServer server = new FTPServer();
        client.send(new FtpCommand(server));

        client.send(new DirCommand(server));
    }
}
