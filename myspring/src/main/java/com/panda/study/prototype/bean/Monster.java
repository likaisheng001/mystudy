package com.panda.study.prototype.bean;

/**
 * Created by Administrator on 2019/7/29.
 */
public class Monster {
    private Integer id = 20;
    private String nickname = "牛魔王";
    private String skill = "芭蕉扇";
    public Monster(){
        System.out.println("monster 创建..");
    }

    public Monster(Integer id, String nickname, String skill) {
        this.id = id;
        this.nickname = nickname;
        this.skill = skill;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", skill='" + skill + '\'' +
                '}';
    }
}
