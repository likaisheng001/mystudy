package com.panda.study.designmodel_gp.command.player.action;/**
 * Created by My on 2020-03-16.
 */

import com.panda.study.designmodel_gp.command.player.GPlayer;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 22:18:35 2020-03-16
 * @Modified By:
 */
public class StopAction implements IAction {
    private GPlayer gPlayer;

    public StopAction(GPlayer gPlayer) {
        this.gPlayer = gPlayer;
    }

    @Override
    public void execute() {
        gPlayer.stop();
    }
}
