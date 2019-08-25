package algorithm.hashtab;

import java.util.Scanner;

/**
 * Created by Administrator on 2019/8/16.
 */
public class HashTabDemo {
    public static void main(String[] args) {
        //创建哈希表
        HashTab hashTab = new HashTab(7);
        //写一个简单的菜单
        String key = "";
        Scanner scan = new Scanner(System.in);
        while (true){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("exit:退出系统");
            key = scan.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scan.nextInt();
                    System.out.println("输入名字");
                    String name = scan.next();
                    //创建雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scan.nextInt();
                    hashTab.findEmpByid(id);
                    break;
                case "exit":
                    scan.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;
    public HashTab(int size){
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }
    //添加雇员
    public void add(Emp emp){
        int empLinkedListNO = hashFun(emp.getNo());
        empLinkedListArray[empLinkedListNO].add(emp);
    }
    public int hashFun(int id){
        return id % size;
    }
    public void findEmpByid(int id){
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].findEmpById(id);
        if (emp != null){
            System.out.printf("在第%d链表中找到该雇员id=%d\n",(empLinkedListNO+1),id);
        }else {
            System.out.println("在哈希表中，没有找到该雇员 --- ");
        }
    }

}
class EmpLinkedList{
    private Emp head;
    public void add(Emp emp){
        if (head == null){
            head = emp;
            return;
        }
        Emp temEmp = head;
        while (temEmp.next != null){
            temEmp = temEmp.next;
        }
        temEmp.next = emp;
    }
    public void list(int no){
        if (head == null){
            System.out.println("第"+(no+1)+"链表为空");
            return;
        }
        System.out.println("第"+(no+1)+"链表的信息为：");
        Emp curEmp = head;
        while (true){
            System.out.printf("=> id = %d name = %s \t",curEmp.getNo(),curEmp.getName());
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }
    public Emp findEmpById(int id){
        if (head == null){
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Emp curEmp = head;
        while (true){
            if (curEmp.getNo() == id){//找到
                break;
            }
            //退出
            if (curEmp.next == null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}
class Emp{
    private int no;
    private String name;
    public Emp next;//next默认为空

    public Emp(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }
}
