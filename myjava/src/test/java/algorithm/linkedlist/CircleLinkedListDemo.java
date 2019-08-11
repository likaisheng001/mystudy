package algorithm.linkedlist;

/**
 * Created by Administrator on 2019/8/11.
 */
public class CircleLinkedListDemo {
    public static void main(String[] args) {
        CircleLinkedList<Integer> circleLinkedList = new CircleLinkedList<Integer>();
        circleLinkedList.add(1);//加入5个小孩节点
        circleLinkedList.add(2);//加入5个小孩节点
        circleLinkedList.add(3);//加入5个小孩节点
        circleLinkedList.add(4);//加入5个小孩节点
        circleLinkedList.add(5);//加入5个小孩节点
        circleLinkedList.show();
        //测试一把小孩出圈是否正确
        circleLinkedList.quitCircle(1,2,5);
    }

}
class CircleLinkedList<E>{
    Node first;//第一个节点，需要存放数据
    public void add(E e){
        Node addNode = new Node(e, first);
        Node tmpNode = first;
        int idx = -1;
        while(tmpNode != null){
            idx++;
            if (idx == size()-1){
                break;
            }
            tmpNode = tmpNode.getNext();
        }
        //第一次添加元素
        if (tmpNode == null){
            first = addNode;
            addNode.setNext(first);
        }else {
            tmpNode.setNext(addNode);
        }
    }
    public void quitCircle(int s,int f,int c){
        Node tmpNode = get(s);
        int num = 0;
        while (size()>1){
            num++;
            if (num == f){
                remove(tmpNode.getData());
                System.out.print("--"+tmpNode.getData()+"---");
                num=0;
            }
            tmpNode = tmpNode.getNext();
        }
        System.out.print("--"+tmpNode.getData()+"---");
    }
    public void add(int index,E e){
        Node addNode = new Node(e, null);
        Node tmpNode = first;
        Node curNode = null;
        Node preNode = null;
        int idx = -1;
        while(tmpNode != null){
            idx++;
            if (idx == index-2){
                break;
            }
            tmpNode = tmpNode.getNext();
        }
        preNode = tmpNode;
        curNode = preNode.getNext();
        preNode.setNext(addNode);
        addNode.setNext(curNode);
    }
    public Node get(int index){
        if (index < 1 || index > size()){
            throw new RuntimeException("position error,get error");
        }
        int idx = -1;
        Node tmpNode = first;
        Node resNode = null;
        while (tmpNode != null){
            idx++;
            if (index - 1 == idx){
                resNode = tmpNode;
                break;
            }
            tmpNode = tmpNode.getNext();
        }
        return resNode;
    }
    public E remove(E e){
        Node tmpNode = first;
        Node preNode = null;//待删除元素的前一个元素
        Node delNode = null;
        while (tmpNode.getNext() != null){
            if (tmpNode.getNext().getData() == e){
                preNode = tmpNode;
                break;
            }
            tmpNode = tmpNode.getNext();
        }
        if (preNode != null){
            delNode = preNode.getNext();
            preNode.setNext(delNode.getNext());
            if (delNode == first){
                first = preNode.getNext();
            }
        }
        return delNode.getData();
    }
    public E remove(int index){
        if (index < 1 || index > size()){
            throw new RuntimeException("position error,remove error");
        }
        Node tmpNode = first;
        Node preNode = null;//待删除元素的前一个元素
        Node delNode = null;
        int idx = -1;
        while (tmpNode != null){
            idx++;
            if (idx == index-2){
                preNode = tmpNode;
                break;
            }
            tmpNode = tmpNode.getNext();
        }
        if (preNode != null){
            delNode = preNode.getNext();
            preNode.setNext(delNode.getNext());
        }
        return delNode.getData();
    }
    int size(){
        Node tmpNode = first;
        int size = 0;
        while (tmpNode != null){
            size++;
            tmpNode = tmpNode.getNext();
            if (first == tmpNode){
                break;
            }
        }
        return size;
    }

    class Node{
        E data;//数据域
        Node next;//指针域

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
        public E getData() {
            return data;
        }
        public void setData(E data) {
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
                    "data=" + data +
                    '}';
        }
    }
    public void show(){
        Node tmpNode = first;
        int idx = -1;
        while (tmpNode != null){
            idx ++;
            if (idx > size()-1){
                break;
            }
            System.out.print(tmpNode.getData() + " ");
            tmpNode = tmpNode.getNext();
        }
    }
}
