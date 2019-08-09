package algorithm.sparsearray;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/8/8.
 */
public class sparsearray {
    public static void main(String[] args) {
        //初始化数组
        int[][] chessboard =new int[6][7];
        chessboard[0][3] = 22;
        chessboard[0][6] = 15;
        chessboard[1][1] = 11;
        chessboard[1][5] = 17;
        chessboard[2][3] = -6;
        chessboard[3][5] = 39;
        chessboard[4][0] = 91;
        chessboard[5][2] = 28;
        System.out.println("---输出稀疏数组-----");
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[0].length; j++) {
                System.out.print(chessboard[i][j]+"\t");
            }
            System.out.println();
        }
        //转换成sparsearray数组
        //统计有效数据
        int sum = 0;
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[0].length; j++) {
                if (chessboard[i][j] != 0){
                    sum++;
                }
            }
        }
        int[][] sparsearray = new int[sum+1][3];
        //保存数组信息
        sparsearray[0][0] = sparsearray.length;
        sparsearray[0][1] = sparsearray[0].length;
        sparsearray[0][2] = sum;
        //定义一个临时变量，用来控制数据的写入
        int k = 1;
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[0].length; j++) {
                if (chessboard[i][j] != 0){
                   sparsearray[k][0] = i;
                   sparsearray[k][1] = j;
                   sparsearray[k][2] = chessboard[i][j];
                   k++;
                }
            }
        }
        //输出稀疏数组
        System.out.println("-----输出稀疏数组---------------");
        for (int i = 0; i < sum + 1; i++) {
            System.out.print(sparsearray[i][0]+"\t"+sparsearray[i][1]+"\t"+sparsearray[i][2]+"\n");
        }
        //将稀疏数组保存到硬盘上
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream("d:\\map.data");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(sparsearray);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //读取数组信息
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        int[][] backup = null;
        try{
            fis = new FileInputStream("d:\\map.data");
            ois = new ObjectInputStream(fis);
            backup= (int[][])ois.readObject();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //输出恢复的数据
        System.out.println("------输出恢复的数据----------");
        for (int i = 0; i < backup.length; i++) {
            System.out.print(backup[i][0]+"\t"+backup[i][1]+"\t"+backup[i][2]+"\n");
        }
    }
}
