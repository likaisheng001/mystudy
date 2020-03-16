package com.panda.study.designmodel_gp.command.player;/**
 * Created by My on 2020-03-16.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 22:15:56 2020-03-16
 * @Modified By:
 */
public class GPlayer {
    public void play(){
        System.out.println("正常播放");
    }
    public void speed(){
        System.out.println("拖动进度条");
    }
    public void stop(){
        System.out.println("停止播放");
    }
    public void pause(){
        System.out.println("暂停播放");
    }
}
