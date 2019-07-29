package com.panda.study.designmodel.builder.improve;

/**
 * Created by Administrator on 2019/7/29.
 */
public class House {
    private String baise;
    private String wall;
    private String roofed;

    @Override
    public String toString() {
        return "House{" +
                "baise='" + baise + '\'' +
                ", wall='" + wall + '\'' +
                ", roofed='" + roofed + '\'' +
                '}';
    }

    public String getBaise() {
        return baise;
    }

    public void setBaise(String baise) {
        this.baise = baise;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }
}
