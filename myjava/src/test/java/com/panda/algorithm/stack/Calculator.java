package com.panda.algorithm.stack;

//编写一个基于中缀表达式的计算器
public class Calculator {
    public static void main(String[] args) {
//        String inStr = "7+2*6-4";
        String inStr = "70+20*6-4";
        ArrayStack2 dataStack = new ArrayStack2(10);
        ArrayStack2 symbolStack = new ArrayStack2(10);
        int resNum = calc_main(dataStack, symbolStack, inStr);
        System.out.println("==========="+resNum+"===========");
    }
    public static int calc_main(ArrayStack2 dataStack,ArrayStack2 symbolStack,String inStr){
        String numStr = "";//用于拼装对位数
        for (int i = 0; i < inStr.length(); i++) {
            char c = inStr.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '\\') {
                if (judgePriority(symbolStack,c)){
                    symbolStack.push(c);
                }else {
                    while (!symbolStack.isEmpty() || !judgePriority(symbolStack,c)){
                        char operate = symbolStack.pop();
                        int num2 = dataStack.pop() - '0';
                        int num1 = dataStack.pop() - '0';
                        int calcRes = calc(num1, num2, operate);
                        calcRes = calcRes + '0';
                        dataStack.push((char)calcRes);
                    }
                    symbolStack.push(c);
                }
            }else {
                //对多位数拼装进行优化
                numStr += c ;
                //判断是否是最后一位，若是，直接进行处理
                if (i == inStr.length()-1){
                    dataStack.push((char)(Integer.parseInt(numStr)+'0'));
                    numStr = "";
                }else {
                    char c2 = inStr.charAt(i+1);
                    if (c2 == '+' || c2 == '-' || c2 == '*' || c2 == '\\'){
                        dataStack.push((char)(Integer.parseInt(numStr) + '0'));
                        numStr = "";
                    }else {
                        continue;
                    }
                }
            }
        }
        while (!symbolStack.isEmpty()){
            char operate = symbolStack.pop();
            int num2 = dataStack.pop() - '0';
            int num1 = dataStack.pop() - '0';
            int calcRes = calc(num1, num2, operate);
            calcRes = calcRes + '0';
            dataStack.push((char)calcRes);
        }
        return dataStack.pop()-'0';
    }

    public static int calc(int num1,int num2,char operate){
        int res = 0;
        if (operate == '+'){
            res = num1 + num2;
        }else if (operate == '-'){
            res = num1 - num2;
        }else if (operate == '*'){
            res = num1 * num2;
        }else if (operate == '\\'){
            res = num1 / num2;
        }else {
            throw new RuntimeException("input expr is error,because contains eror symbol!");
        }
        return res;
    }
    /**
     *
     * @param symbolStack
     * @param c
     * @return 如果c比栈中的优先级大，则返回true,否则返回false
     */
    public static boolean judgePriority(ArrayStack2 symbolStack,char c){
        if (symbolStack.isEmpty()){
            return true;
        };
        char operate = symbolStack.peek();
        return (c == '*' || c == '\\') && (operate == '+' || operate == '-') ? true : false;
    }
}
class ArrayStack2{
    int maxSize;
    char[] stack;
    int top;//栈顶指针

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new char[maxSize];
        top = -1;
    }

    public boolean isFull(){
        return top == maxSize-1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public char pop(){
        if (!isEmpty()){
            return stack[top--];
        }else {
            throw new RuntimeException("stack is empty");
        }
    }
    public char peek(){
        if (!isEmpty()){
            return stack[top];
        }else {
            throw new RuntimeException("stack is empty");
        }
    }
    public void push(char e){
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
