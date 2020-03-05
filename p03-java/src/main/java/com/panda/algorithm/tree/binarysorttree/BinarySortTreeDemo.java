package com.panda.algorithm.tree.binarysorttree;

/**
 * Created by Administrator on 2019/7/18.
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int arr[] = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环的添加结点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        //中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树");
        binarySortTree.infixOrder();
        //测试一下删除叶子节点
        binarySortTree.delNode(2);
        binarySortTree.delNode(5);
        binarySortTree.delNode(9);
        binarySortTree.delNode(12);
        binarySortTree.delNode(7);
        binarySortTree.delNode(3);
        binarySortTree.delNode(10);
        binarySortTree.delNode(1);
        System.out.println("删除节点后...");
        binarySortTree.infixOrder();
        System.out.println("get root="+binarySortTree.getRoot());
    }
}
//创建二叉排序树
class BinarySortTree{
    private Node root;
    //查找要删除的节点
    public Node search(int value){
        if (root == null){
            return null;
        }else{
            return root.search(value);
        }
    }

    public Node getRoot() {
        return root;
    }

    //查找父结点
    public Node searchParent(int value){
        if (root == null){
            return null;
        }else {
            return root.searchParent(value);
        }

    }
    //编写方法
    //1.返回的是以node为根节点的二叉排序树的最小节点的值
    //2.删除node为根节点的二叉排序树的最小节点
    /**
     * @param node 传入的节点(当做二叉排序树的根节点)
     * @return 返回的是以node为根节点的二叉排序树的最小节点的值
     */
    public int delRightTreeMin(Node node){
        Node target = node;
        //循环的查找左子节点，就会找到最小值
        while (target.left != null){
            target = target.left;
        }
        //这是target就指向了最小节点
        //删除最小节点
        delNode(target.value);
        return target.value;
    }
    //删除节点
    public void delNode(int value){
        if (root == null){
            return;
        }else {
            //1.需求先去找到要删除的结点  targetNode
            Node targetNode = search(value);
            //如果没有找到要删除的结点
            if (targetNode == null){
                return;
            }
            //如果我们发现当前这颗二叉排序树只有一个节点
            if (root.left == null && root.right == null){
                root = null;
                return;
            }
            //去找到targetNode的父结点
            Node parent = searchParent(value);
            //第一种情况：如果要删除的是叶子节点
            if (targetNode.left == null && targetNode.right == null){
                //判断targetNode是父结点的左子节点还是右子节点
                if (parent.left != null && parent.left.value == targetNode.value){
                    parent.left = null;
                }else if (parent.right != null && parent.right.value == targetNode.value){
                    parent.right = null;
                }
            //第三种情况：删除有两颗子树的情况
            }else if (targetNode.left != null && targetNode.right != null){
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
                //第二种情况：删除只有一颗子树的情况
            }else {
                //如果要删除的结点有左子节点
                if (targetNode.left != null){
                    if (parent != null){
                        //如果targetNode是parent的左子节点
                        if (parent.left.value == value){
                            parent.left = targetNode.left;
                        }else {//targetNode是parent的右子节点
                            parent.right = targetNode.left;
                        }
                    }else {
                        root = targetNode.left;
                    }
                }else {//要删除的结点有右子节点
                    if (parent != null){
                        if (parent.left.value == value){
                            parent.left = targetNode.right;
                        }else {//如果targetNode是parent的右子节点
                            parent.right = targetNode.right;
                        }
                    }else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }
    //添加节点的方法
    public void add(Node node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }
    public void infixOrder(){
        if (root != null){
            root.infixOrder();
        }else {
            System.out.println("二叉排序树为空，不能遍历...");
        }
    }
}
class Node{
    int value;
    Node left;
    Node right;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //查找要删除的节点
    /**
     *
     * @param value 希望要删除的结点的值
     * @return 如果找到返回该结点，否则返回null
     */
    public Node search(int value){
        if (value == this.value){//找到该结点
            return this;
        }else if (value < this.value){//如果查找的值小于当前结点，向左子树递归查找
            //如果左子节点为空
            if (this.left == null){
                return null;
            }
            return this.left.search(value);
        }else{
            if (this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }
    //查找要删除结点的父节点
    /**
     *
     * @param value 要找到的节点的值
     * @return 返回的是要删除的节点的父节点，如果没有就返回null
     */
    public Node searchParent(int value){
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)){
            return this;
        }else {
            //如果查找的值小于当前结点的值，并且当前结点的左子节点不为空
            if (value < this.value && this.left != null){
                return this.left.searchParent(value);//向左子树递归查找
            }else if (value >= this.value && this.right != null){
                return this.right.searchParent(value);//向右子树递归查找
            }else {
                return null;//没有找到父节点
            }
        }
    }
    public Node(int value) {
        this.value = value;
    }
    //添加节点的方法
    //递归的形式添加节点，注意需要满足二叉排序树的需求
    public void add(Node node){
        if (node == null){
            return;
        }
        //判断传入的节点的值和当前子树的根节点的值的关系
        if (node.value < this.value){
            if (this.left == null){
                this.left = node;
            }else {
                //递归的向左子树添加
                this.left.add(node);
            }
        }else {//添加的节点的值大于当前节点的值
            if (this.right == null){
                this.right = node;
            }else {
                //递归的向右子树添加
                this.right.add(node);
            }
        }
    }
    //中序遍历
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }
}
