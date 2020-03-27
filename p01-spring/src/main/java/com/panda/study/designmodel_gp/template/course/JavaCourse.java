package com.panda.study.designmodel_gp.template.course;/**
 * Created by My on 2020-03-26.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 20:04:55 2020-03-26
 * @Modified By:
 */
public class JavaCourse extends AbstractCourse {
    private boolean needCheckHomework = false;

    public void setNeedCheckHomework(boolean needCheckHomework) {
        this.needCheckHomework = needCheckHomework;
    }

    @Override
    protected void checkHomeHomework() {
        System.out.println("检查Java作业");
    }

    @Override
    protected boolean needCheckHomework() {
        return this.needCheckHomework;
    }
}
