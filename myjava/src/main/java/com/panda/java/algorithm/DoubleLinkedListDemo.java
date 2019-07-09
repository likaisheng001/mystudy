package com.panda.java.algorithm;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试 - - - ");
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(6, "林冲", "豹子头");
        //创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.list();

        System.out.println("顺序添加 - - - - ");
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.addByOrder(newHeroNode);
        doubleLinkedList.list();

    }
}
//创建一个双向链表的类
class DoubleLinkedList{
    //先初始化一个头节点，头节点不能动，不存放具体的数据
    private HeroNode2 head = new HeroNode2(0,"","");
    public HeroNode2 getHead() {
        return head;
    }
    //遍历双向链表的方法
    public void list(){
        if (head.next == null){
            System.out.println("链表为空 - - - - ");
            return;
        }
        HeroNode2 temp = head.next;
        while (true){
            //判断是否到链表最后
            if (temp == null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            temp = temp.next;
        }
    }
    //第二种方式添加-顺序添加
    //双向链表的顺序添加思路：找位置，添加
    public void addByOrder(HeroNode2 heroNode){
        //因为头节点不能动，因此我们需要通过一个辅助指针(变量)来帮助找到添加的位置
        HeroNode2 temp = head;
        boolean flag = false; //标志添加的编号是否存在，默认为false
        while (true){
            if (temp.next == null){ //说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no){ //找到位置,就在temp的后面插入
                break;
            }else if (temp.next.no == heroNode.no) { // 说明希望添加heroNode的编号已然存在
                flag = true; //说明编号存在
                break;
            }
            temp = temp.next;
        }
        //判断flag的值
        if (flag){ //不能添加,说明编号存在
            System.out.printf("准备插入的英雄的编号%d已经存在了,不能加入\n",heroNode.no);
        }else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            heroNode.pre = temp;
            temp.next = heroNode;
        }
    }
    //添加一个节点到双向链表中
    public void add(HeroNode2 heroNode){
        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while (true){
            //找到链表的最后
            if (temp.next == null){
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }
    //修改一个节点的内容，可以看到双向链表的节点内容修改和单向链表一样
    public void update(HeroNode2 newHeroNode){
        if (head.next == null){
            System.out.println("链表为空 - - - ");
        }
        //找到需要修改的节点
        HeroNode2 temp = head.next;
        boolean flag = false; //表示是否找到该节点
        while (true){
            if (temp == null){
                break; //已经遍历完链表
            }
            if (temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {
            System.out.printf("没有找到编号%d的节点,不能修改\n",newHeroNode.no);
        }
    }
    //从双向链表中删除一个节点
    //1.对于双向链表，我们可以直接找到要删除的这个节点
    //2.找到后，自我删除即可
    public void del(int no){
        //判断当前链表是否为空
        if(head.next == null){
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next; //辅助变量(指针)
        boolean flag = false; //标志是否找到待删除的节点
        while (true){
            if (temp == null){ // 已经到链表的最后
                break;
            }
            if (temp.no == no){
                //找到了待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next; // temp后移,遍历
        }
        if (flag){
            //temp.next = temp.next.next; [单向链表]
            temp.pre.next = temp.next;
            //这里我们的代码有问题？
            //如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.printf("要删除的%d节点不存在\n",no);
        }
    }
}
//定义HeroNode,每个HeroNode对象就是一个节点
class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;
    public HeroNode2(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //为了显示方便，我们重新toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
