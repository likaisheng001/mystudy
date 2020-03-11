package com.panda.study.designmodel_gp.bridge.course;/**
 * Created by My on 2020-03-11.
 */


/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 19:26:09 2020-03-11
 * @Modified By:
 */
public class AbstractCourse implements ICourse {
    private INote note;
    private IVideo video;

    @Override
    public String toString() {
        return "AbstractCourse{" +
                "note=" + note +
                ", video=" + video +
                '}';
    }


    public void setNote(INote note) {
        this.note = note;
    }

    public void setVideo(IVideo video) {
        this.video = video;
    }
}
