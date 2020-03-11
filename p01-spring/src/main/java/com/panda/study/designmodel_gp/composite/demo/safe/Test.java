package com.panda.study.designmodel_gp.composite.demo.safe;/**
 * Created by My on 2020-03-11.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 08:26:20 2020-03-11
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("------------------安全模式写法-----------------------");
        File qq = new File("QQ.exe");
        File wr = new File("微信.exe");

        Folder office = new Folder("办公软件",2);
        File word = new File("Word.exe");
        File ppt = new File("Ppt.exe");
        File excel = new File("Excel.exe");

        office.add(word);
        office.add(ppt);
        office.add(excel);

        Folder root = new Folder("D盘",1);

        root.add(office);
        root.add(qq);
        root.add(wr);

        System.out.println("--------------show--------------");
        root.show();
        System.out.println("--------------list--------------");
        root.list();
    }
}
