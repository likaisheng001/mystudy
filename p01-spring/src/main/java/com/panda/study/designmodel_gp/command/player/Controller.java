package com.panda.study.designmodel_gp.command.player;/**
 * Created by My on 2020-03-16.
 */

import com.panda.study.designmodel_gp.command.player.action.IAction;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 22:20:18 2020-03-16
 * @Modified By:
 */
public class Controller {
    private List<IAction> actions = new ArrayList<IAction>();

    public void addAction(IAction action){
        actions.add(action);
    }

    public void execute(IAction action){
        action.execute();
    }
    public void executes(){
        for (IAction action : actions){
            action.execute();
        }
        actions.clear();
    }
}
