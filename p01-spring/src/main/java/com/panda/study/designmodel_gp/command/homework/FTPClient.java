package com.panda.study.designmodel_gp.command.homework;/**
 * Created by My on 2020-03-18.
 */


import com.panda.study.designmodel_gp.command.homework.command.ICommand;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:27:30 2020-03-18
 * @Modified By:
 */
public class FTPClient {
    public void send(ICommand command){
        command.execute();
    }
}
