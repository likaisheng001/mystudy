package com.panda.study.designmodel.iterator;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/8/5.
 */
public class Client {
    public static void main(String[] args) {
        //创建学院
        ArrayList<College> collegeList = new ArrayList<College>();
        ComputerCollege computerCollege = new ComputerCollege();
        InfoCollege infoCollege = new InfoCollege();

        collegeList.add(computerCollege);
        collegeList.add(infoCollege);

        OutPutImpl outPutImpl = new OutPutImpl(collegeList);
        outPutImpl.printCollege();
    }
}
