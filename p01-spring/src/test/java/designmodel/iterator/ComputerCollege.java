package designmodel.iterator;

import java.util.LinkedList;

/**
 * Created by Administrator on 2019/8/30.
 */
public class ComputerCollege implements College{
    private String name = "计算机学院";
    private LinkedList<Department> departmentLinkedList;

    public ComputerCollege() {
        departmentLinkedList = new LinkedList<Department>();
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator();
    }

    public void addDepartment(Department department){
        departmentLinkedList.add(department);
    }
    class ComputerCollegeIterator implements Iterator<Department>{
        private int idx = -1;

        @Override
        public boolean hasNext() {
            return departmentLinkedList != null && departmentLinkedList.size() > idx+1 ? true : false;
        }

        @Override
        public Department next() {
            return departmentLinkedList.get(++idx);
        }

        //迭代器定义的这个方法，还为使用过，需要注意，这个方法的具体功能是什么
        //感觉这个方法的设计，有点违背迭代器模式的设计原则（只遍历不管理）
        @Override
        public void remove() {

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
