package com.panda.algorithm.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero2);

        singleLinkedList.list();
//        System.out.println("------------");
//        reverseList(singleLinkedList.getHead());
//        singleLinkedList.list();
        System.out.println("测试逆序打印");
        reversePrint(singleLinkedList.getHead());
    }
    //将单链表反转
    public static void reverseList(HeroNode head){
        if (head.next == null || head.next.next == null){
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null; //指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");
        while (cur != null){
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }
    public static void reversePrint(HeroNode head){
        if (head.next == null){
            return;//空链表，不能打印
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
}

//定义SingleLinkedList管理我们的英雄
class SingleLinkedList{
    //先初始化一个头节点，头节点不能动，不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode){

        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp = head;
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
        //将最后这个节点的next指向新的节点
        temp.next = heroNode;
    }
    //第二种方式添加-顺序添加
    public void addByOrder(HeroNode heroNode){
        //因为头节点不能动，因此我们需要通过一个辅助指针(变量)来帮助找到添加的位置
        //因为是单链表，因此我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
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
            temp.next = heroNode;
        }
    }

    //修改节点的信息,根据no编号来修改，即no编号不能改
    //根据newHeroNode的no来修改即可
    public void update(HeroNode newHeroNode){
        if (head.next == null){
            System.out.println("链表为空 - - - ");
        }
        //找到需要修改的节点
        HeroNode temp = head.next;
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
    //删除节点
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){ // 已经到链表的最后
                break;
            }
            if (temp.next.no == no){
                //找到了待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next; // temp后移,遍历
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的%d节点不存在\n",no);
        }
    }
    //显示链表[链表]
    public void list(){
        if (head.next == null){
            System.out.println("链表为空 - - - - ");
            return;
        }
        HeroNode temp = head.next;
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
}
//定义HeroNode,每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;
    public HeroNode(int no,String name,String nickname){
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
