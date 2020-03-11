package com.panda.study.designmodel_gp.composite.demo.safe;/**
 * Created by My on 2020-03-11.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 08:19:13 2020-03-11
 * @Modified By:
 */
public class Folder extends Directory {
    private List<Directory> dirs;
    private Integer level;

    public Folder(String name,Integer level) {
        super(name);
        this.level = level;
        this.dirs = new ArrayList<Directory>();
    }

    @Override
    public void show() {
        System.out.println(this.name);
        for (Directory d : dirs){
            if (this.level != null){
                for (int i = 0; i < this.level; i++) {
                    System.out.print("    ");
                }
                for (int i = 0; i < this.level; i++) {
                    if (i == 0){
                        System.out.print("+");
                    }
                    System.out.print("-");
                }
            }
            d.show();
        }
    }

    public boolean add(Directory dir){
        return this.dirs.add(dir);
    }

    public boolean remove(Directory dir){
        return this.dirs.remove(dir);
    }

    public Directory get(int index){
        return this.dirs.get(index);
    }

    public void list(){
        for (Directory d : dirs){
            System.out.println(d.name);
        }
    }

}
