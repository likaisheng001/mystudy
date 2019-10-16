package com.panda.algorithm.linkedlist;

/**
 * Created by Administrator on 2019/8/11.
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkList singleLinkList = new SingleLinkList();
//        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
//        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
//        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
//        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        singleLinkList.add(new DataType(1, "宋江", "及时雨"));
        singleLinkList.add(new DataType(2, "卢俊义", "玉麒麟"));
        singleLinkList.add(new DataType(3, "吴用", "智多星"));
        singleLinkList.add(new DataType(4, "林冲", "豹子头"));
        singleLinkList.show();
        singleLinkList.del(4);
        singleLinkList.show();
    }

}

//用户自定义数据类型(此处可用泛型处理)：此处用来保证梁山好汉信息
class DataType{
    public int no;//好汉排名
    public String name;//好汉姓名
    public String nickname;//好汉外号

    public DataType(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "DataType{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
//定义单链表
class SingleLinkList{
    Node head;//头节点
    public SingleLinkList() {
        this.head = new Node(null,null);
    }
    //默认采用最后插入添加元素
    public void add(DataType x){
        Node node = new Node(x,null);
        Node tmpNode = head;
        while (tmpNode.next != null){
            tmpNode = tmpNode.next;
        }
        tmpNode.next = node;
    }
    public void add(int index,DataType e){
        if (index < 1 || index > size() + 1){
            throw new RuntimeException("add position error,add error!");
        }
        Node addNode = new Node(e);
        Node preNode = get(index - 1);
        Node curNade = preNode.next;
        preNode.next = addNode;
        addNode.setNext(curNade);
    }
    public int size(){
        int res = 0;
        Node tmpNode = head;
        while (tmpNode.next != null){
            tmpNode = tmpNode.next;
            res++;
        }
        return res;
    }
    //找不到返回null
    public Node get(int index){
        Node temNode = head;
        Node resNode = null;
        int idx = -1;
        while (temNode.next != null){
            idx++;
            temNode = temNode.next;
            if (idx == (index-1)){
                resNode = temNode;
                break;
            }
        }
        return resNode;
    }
    public void show(){
        System.out.println("-----输出好汉信息-----------");
        Node tmpNode = head;
        while (tmpNode.next != null){
            tmpNode = tmpNode.next;
            System.out.println(tmpNode);
        }
    }
    public Node del(int index){
        if (index < 1 || index > size()){
            throw new RuntimeException("del position error,remove error!");
        }
        Node preNode = this.get(index-1);
        Node delNode = preNode.getNext();
        preNode.setNext(delNode.getNext());
        return delNode;
    }
    //定义链表的结点
    class Node{
        DataType data;//数据域
        Node next;//指针域

        public Node(DataType data) {
            this.data = data;
        }

        public Node(DataType data, Node next) {
            this.data = data;
            this.next = next;
        }
        public DataType getData() {
            return data;
        }
        public void setData(DataType data) {
            this.data = data;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data + '}';
        }
    }
}
