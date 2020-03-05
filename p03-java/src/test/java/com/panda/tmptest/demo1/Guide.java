package com.panda.tmptest.demo1;/**
 * Created by My on 2019-12-12.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 14:27:13 2019-12-12
 * @Modified By:
 */
public class Guide {

    private String guideName;
    private Integer num = 0;

    public Guide(String guideName, Integer num) {
        this.guideName = guideName;
        this.num = num;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
