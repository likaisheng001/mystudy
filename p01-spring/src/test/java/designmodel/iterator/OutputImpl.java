package designmodel.iterator;

import java.util.LinkedList;

/**
 * Created by Administrator on 2019/8/30.
 */
public class OutputImpl {
    private LinkedList<College> collegeLinkedList;

    public OutputImpl() {
        collegeLinkedList = new LinkedList<College>();
    }
    public void addCollege(College college){
        collegeLinkedList.add(college);
    }
    public void show(){
        Iterator iterator = null;
        for (int i = 0; i < collegeLinkedList.size(); i++) {
            College college = collegeLinkedList.get(i);
            iterator = college.createIterator();
            System.out.println("-------------"+college.getName()+"-----------");
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }
}
