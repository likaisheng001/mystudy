package algorithm.stack;

import java.util.Scanner;

/**
 * Created by Administrator on 2019/8/14.
 */
//设计顺序栈
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("show:表示显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:表示添加数据到栈(入栈)");
            System.out.println("pop:表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出 - - - ");
    }
}
class ArrayStack{
    int maxSize;
//    DataType[] stack;
    int[] stack;
    int top;//栈顶指针
//    class DataType{
//    }

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
        top = -1;
    }

    public boolean isFull(){
        return top == maxSize-1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public int pop(){
        if (!isEmpty()){
            return stack[top--];
        }else {
            throw new RuntimeException("stack is empty");
        }
    }
    public void push(int e){
        if (!isFull()){
            stack[++top]=e;
        }else {
            throw new RuntimeException("stack is full");
        }
    }
    public void list(){
        if (!isEmpty()){
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + "  ");
            }
        }else {
            System.out.println("stack is empty");
        }
    }
}
