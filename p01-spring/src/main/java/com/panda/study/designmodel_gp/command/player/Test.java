package com.panda.study.designmodel_gp.command.player;/**
 * Created by My on 2020-03-16.
 */

import com.panda.study.designmodel_gp.command.player.action.PauseAction;
import com.panda.study.designmodel_gp.command.player.action.PlayAction;
import com.panda.study.designmodel_gp.command.player.action.SpeedAction;
import com.panda.study.designmodel_gp.command.player.action.StopAction;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 22:20:45 2020-03-16
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        GPlayer player = new GPlayer();
        // 支持批量处理或单个处理
        Controller controller = new Controller();

        PauseAction pause = new PauseAction(player);
        PlayAction play = new PlayAction(player);
        SpeedAction speed = new SpeedAction(player);
        StopAction stop = new StopAction(player);

        controller.addAction(pause);
        controller.addAction(play);
        controller.addAction(speed);
        controller.addAction(stop);

        controller.executes();
    }
}
