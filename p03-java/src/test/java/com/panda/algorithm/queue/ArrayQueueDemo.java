package com.panda.algorithm.queue;

import java.util.Scanner;

/**
 * Created by Administrator on 2019/8/9.
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0); // 接收一个字符
            switch (key){
                case 's':
                    queue.show();;
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;
                case 'g':
                    try {
                        int res = queue.remove();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.peek();
                        System.out.printf("队列头的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
//队列是一种先进先出的数据结构，准确的来说，是一种理念
//关于队列的操作：add、pop、peak、clear (不支持删除)
//如何判断栈空、栈满
//对队列进行改进-循环队列
class ArrayQueue{
    //队列容量
    private int maxSize;
    //设置头尾指针
    //定义：永远指向对列首部元素的前一个元素
    private int front;
    //定义：永远指向队列尾部元素，初始化时，队列没有元素，故指向队列前一个元素
    private int rear;
    private int[] arr;//用来存储具体的数据

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }
    //判断队列空方法
    public boolean isEmpty(){
        return (rear == -1 || front == rear) ? true : false;
    }
    //判断队列满的方法
    public boolean isFull(){
        return rear == maxSize-1 ? true : false;
    }
    //添加元素
    public void add(int e){
        if (!isFull()){
            arr[++rear] = e;
        }else{
            throw new RuntimeException("queue is full,insert fault!");
        }
    }
    //移除元素
    public int remove(){
        if (!isEmpty()){
           return arr[++front];
        }else {
           throw new RuntimeException("queue is empty,remore fault!");
        }
    }
    //peek 查看头元素
    public int peek(){
        if (!isEmpty()){
            return arr[front+1];
        }else {
            throw new RuntimeException("queue is empty,peek fault!");
        }
    }
    //此方法仅为测试
    public void show(){
       if (isEmpty()){
           System.out.println("queue is empty,no data ...");
       }else {
           for (int i = 0; i < maxSize; i++) {
               System.out.printf("arr[%d]=%d\n",i,arr[i]);
           }
       }
    }
}
