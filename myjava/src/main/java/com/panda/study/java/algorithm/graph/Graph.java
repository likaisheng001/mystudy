package com.panda.study.java.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2019/7/20.
 */
public class Graph {
    private ArrayList<String> vertexList; //存储顶点的集合
    private int[][] edges;//存储图对应的邻结矩阵
    private int numOfEdges;//表示边的数目
    public static void main(String[] args) {
        //测试一把图是否创建ok
        int n = 5; //节点的个数
        String vertexValue[] = {"A","B","C","D","E"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加顶点
        for (String value: vertexValue) {
            graph.insertVertex(value);
        }
        //添加边A-B A-C B-C B-D B-E
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        //显示一把邻结矩阵
        graph.showGraph();
    }
    public Graph(int n){
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
    }
    //图中常用的方法
    //返回节点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //得到边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //返回节点i(下标)对应的数据
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    //返回v1和v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    //插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    //显示图对应的矩阵
    public void showGraph(){
        for (int[] link:edges) {
            System.out.println(Arrays.toString(link));
        }
    }
    //添加边
    /**
     * @param v1 表示点的下标即是第几个顶点
     * @param v2 表示第二个顶点的下标
     * @param weight
     */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges ++;
    }
}
