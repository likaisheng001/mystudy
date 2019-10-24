package com.panda.serialPort.glodDragon;/**
 * Created by My on 2019/10/23.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:02 2019/10/23
 * @Modified By:
 */
public enum  WeighBridgeCommandEnum {
    A("024141303003","握手"),
    B("024142303303","读毛重"),
    C("024143303203","读皮重"),
    D("024144303503","读净重"),
    E("024145303403","读车号"),
    F("024146303703","读货号");
    private String command;
    private String desc;

    WeighBridgeCommandEnum(String command,String desc) {
        this.command = command;
        this.desc = desc;
    }

    public String getCommand() {
        return command;
    }
    public String getDesc() {
        return desc;
    }
}
