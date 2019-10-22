package com.panda.algorithm.common10algorithm;

import java.util.Arrays;

/**
 * Created by My on 2019/10/16.
 */
public class Dijkstra{
    public static void main(String[] args) {
        char[] vertex = {'A','B','C','D','E','F','G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[]{N,5,7,N,N,N,2};
        matrix[1] = new int[]{5,N,N,9,N,N,3};
        matrix[2] = new int[]{7,N,N,N,8,N,N};
        matrix[3] = new int[]{N,9,N,N,N,4,N};
        matrix[4] = new int[]{N,N,8,N,N,5,4};
        matrix[5] = new int[]{N,N,N,4,5,N,6};
        matrix[6] = new int[]{2,3,N,N,4,6,N};
        Graph graph = new Graph(vertex,matrix);
        graph.showGraph();
        graph.dsj(6);
        graph.showDijkstra();
    }
}
//用来保存图
class Graph{
    private char[] vertex;
    private int[][] matrix;//邻接矩阵
    private VisitedVertex vv; //已经访问过的顶点的集合

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }
    public void showGraph(){
        for (int[] link:matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * Dijkstral算法实现
     * @param index
     */
    public void dsj(int index){
        vv = new VisitedVertex(vertex.length,index);
        update(index);
        for (int i = 1; i < vertex.length; i++) {
            index = vv.updateArr();
            update(index);
        }
    }
    private void update(int index){
        int len = 0;
        for (int i = 0; i < matrix[index].length; i++) {
            len = vv.getDis(index) + matrix[index][i];
            if (!vv.in(i) && len < vv.getDis(i)){
                vv.updatePre(i,index);
                vv.updateDis(i,len);
            }
        }
    }
    public void showDijkstra(){
        vv.show();
    }
}
//已访问的顶点集合
class VisitedVertex{
    //记录各个顶点的访问情况，1-表示访问过，0-表示未访问
    public int[] already_arr;
    //每个下标对应的值为前一个顶点
    public int[] pre_visited;
    //记录出发顶点到其他所有顶点的距离
    public int[] dis;

    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];

        Arrays.fill(dis,65535);
        this.already_arr[index] = 1;
        this.dis[index] = 0;
    }

    /**
     * 功能：判断index顶点是否被访问过
     * @param index
     * @return
     */
    public boolean in(int index){
        return already_arr[index] == 1;
    }

    /**
     * 功能：更新出发顶点到index顶点的距离
     * @param index
     * @param len
     */
    public void updateDis(int index,int len){
        dis[index] = len;
    }

    /**
     * 功能：更新pre顶点的前驱顶点为index节点
     * @param pre
     * @param index
     */
    public void updatePre(int pre,int index){
        pre_visited[pre] = index;
    }
    public int getDis(int index){
        return dis[index];
    }
    //继续选择并返回新的访问顶点，比如这里的G完后，就是A点作为新的访问顶点(注意不是出发顶点)
    public int updateArr(){
        int min = 65535,index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min){
                min = dis[i];
                index = i;
            }
        }
        //根据index顶点被访问过
        already_arr[index] = 1;
        return index;
    }
    //显示最后的结果
    //即将三个数据的情况输出
    public void show(){
        System.out.println("===================");
        for (int i:already_arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        //输出pre_visited
        for (int i:pre_visited) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i:dis) {
            System.out.print(i + " ");
        }
        System.out.println();
        char[] vertex = {'A','B','C','D','E','F','G'};
        int count = 0;
        for (int i:dis) {
            if(i != 65535){
                System.out.print(vertex[count] + "(" + i + ")");
            }else{
                System.out.print("N");
            }
            count++;
        }
        System.out.println();
    }
}
