package designmodel.iterator;

import java.util.LinkedList;

/**
 * Created by Administrator on 2019/8/30.
 */
public class InfoColleage implements  College{
    private String name = "信息学院";
    private LinkedList<Department> departmentLinkedList;

    public InfoColleage() {
        departmentLinkedList = new LinkedList<Department>();
    }

    @Override
    public Iterator createIterator() {
        return new InfoCollegeIterator();
    }
    public void addDepartment(Department department){
        departmentLinkedList.add(department);
    }
    class InfoCollegeIterator implements Iterator<Department>{
        private int idx = -1;
        @Override
        public boolean hasNext() {
            return departmentLinkedList != null && departmentLinkedList.size() > idx+1 ? true : false;
        }

        @Override
        public Department next() {

            return departmentLinkedList.get(++idx);
        }

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
