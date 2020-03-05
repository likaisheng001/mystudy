package com.panda.algorithm.huffmancode;

import java.io.*;
import java.util.*;

/**
 * Created by Administrator on 2019/7/17.
 */
public class HuffmanCode {
    public static void main(String[] args) {
        //测试压缩文件 黑白图片压缩效果更好，彩色图片压缩效果不好
        String srcFile = "d://src.bmp";
        String dstFile = "d://dst.zip";
        zipFile(srcFile, dstFile);
        System.out.println("压缩文件成功...");
        //测试解压文件
//        String zipFile = "d://dst.zip";
//        String dstFile = "d://src2.bmp";
//        unZipFile(zipFile,dstFile);
//        System.out.println("解压成功...");
        /*
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        byte[] huffmanCodesBytes = huffmanZip(contentBytes);
        System.out.println("压缩后的结果是：" + Arrays.toString(huffmanCodesBytes) + "长度为=" + huffmanCodesBytes.length);

        byte[] sourceBytes = decode(huffmanCodes, huffmanCodesBytes);
        System.out.println("原来的字符串=" + new String(sourceBytes));
        */
    }
    //编写一个方法，完成对压缩文件的解压

    /**
     * @param zipFile 准备解压的文件
     * @param dstFile 将文件解压到哪个路径
     */
    public static void unZipFile(String zipFile, String dstFile) {
        //定义文件的输入流
        InputStream is = null;
        //定义一个对象输入流
        ObjectInputStream ois = null;
        //定义文件的输出流
        OutputStream os = null;
        try {
            //创建文件输入流
            is = new FileInputStream(zipFile);
            //创建一个和is关联的对象输入流
            ois = new ObjectInputStream(is);
            //读取byte数组 huffmanBytes
            byte[] huffmanBytes = (byte[]) ois.readObject();
            //读取赫夫曼编码表
            Map<Byte, String> codes = (Map<Byte, String>) ois.readObject();
            //解码
            byte[] bytes = decode(codes, huffmanBytes);
            //将bytes数组写入到目标文件
            os = new FileOutputStream(dstFile);
            os.write(bytes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
    //编写方法，将一个文件进行压缩

    /**
     * @param srcFile 你传入的希望压缩的文件的全路径
     * @param dstFile 我们压缩后将压缩文件放到哪个目录
     */
    public static void zipFile(String srcFile, String dstFile) {
        //创建输出流
        OutputStream os = null;
        ObjectOutputStream oos = null;
        //创建文件的输入流
        FileInputStream is = null;
        try {
            is = new FileInputStream(srcFile);
            //创建一个和源文件大小一样的byte[]
            byte[] b = new byte[is.available()];
            //读取文件
            is.read(b);
            //对源文件进行压缩
            byte[] huffmanBytes = huffmanZip(b);
            //创建文件的输出流,存放压缩文件
            os = new FileOutputStream(dstFile);
            //创建一个和文件输出流关联的ObjectOutputStream
            oos = new ObjectOutputStream(os);
            //把赫夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);
            //这里我们以对象流的方式写入赫夫曼编码表,是为了以后我们恢复源文件时使用
            //注意：一定要把赫夫曼编码表 写入压缩文件
            oos.writeObject(huffmanCodes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (oos != null) {
                    oos.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


    }
    //使用一个方法，将前面的方法封装起来，便于我们的调用

    /**
     * 数据压缩
     *
     * @param bytes 原始的字符串对应的字节数组
     * @return 返回的是经过赫夫曼编码处理后的字节数组(压缩后的数组)
     */
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        //根据nodes创建赫夫曼树
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        //得到赫夫曼编码表
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        //生成赫夫曼编码
        byte[] huffmanCodesBytes = zip(bytes, huffmanCodes);
        return huffmanCodesBytes;
    }
    //数据解压
    //思路
    //1.将huffmanCodesBytes [-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
    //  先转成赫夫曼编码对应的二进制的字符串"1010100010111111110010001011111..."
    //2.将得到的二进制字符串"1010100010111111110010001011111..." => 对照赫夫曼编码表 => "i like like like java do you like a java"
    //编写一个方法，完成对压缩数据的解码

    /**
     * @param huffmanCodes 赫夫曼编码表
     * @param huffmanBytes 赫夫曼编码得到的字节数组
     * @return 返回的就是原来的字符串对应的数组
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        //1.先得到huffmanBytes对应的二进制的字符串1010100010111111110010001011111...
        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组转成二进制的字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            //判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, huffmanBytes[i]));
        }
//        System.out.println("赫夫曼字节数组转对应的二进制字符串=" + stringBuilder.toString());
        //把字符串按照指定的赫夫曼编码进行解码
        //把赫夫曼编码表进行调换，因为要反向查询a -> 100  200 -> a
        Map<String, Byte> map = new HashMap<String, Byte>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        //创建一个集合，存放byte
        List<Byte> list = new ArrayList<>();
        //1 可以理解成就是索引，扫描stringBuilder
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;//小的计数器
            boolean flag = true;
            Byte b = null;
            while (flag) {
                //1010100010111111110010001011111...
                //取出一个'1' '0'
                String key = stringBuilder.substring(i, i + count); //i不动，让count移动，直到匹配到一个字符
                b = map.get(key);
                if (b == null) { //说明没有匹配到
                    count++;
                } else {//匹配到
                    flag = false;
                }
            }
            list.add(b);
            i += count;//i 直接移动到count
        }
        //当for循环结束后，我们list中就存放了所有的字符"i like like like java do you like a java"
        //把list中的数据放入到byte[]并返回
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    /**
     * 将一个byte转成一个二进制的字符串
     *
     * @param flag 标识是否需要补高位 true:表示需要补高位，false：表示不用补高位;如果是最后一个字节，不需要补高位
     * @param b    传入的byte
     * @return 是该b对应的二进制的字符串(注意是按补码返回)
     */
    private static String byteToBitString(boolean flag, byte b) {
        //使用变量保存b
        int temp = b; //将b转成int
        if (flag) {
            //如果byte b = -1正常，如果b是正数我们还存在补高位
            //按位与 256 = 1 0000 0000     1 = 0000 0001
            //0000 0001 | 1 0000 0000 = 1 0000 0001
            temp |= 256;
        }
        //这个地方返回的是temp对应的二进制的补码
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    //前序遍历的方法
    private static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("赫夫曼树为空");
        }
    }

    //接收字节数组，返回的就是List=[Node[date=97 ,weight = 5], Node[date=32,weight = 9]......]
    private static List<Node> getNodes(byte[] bytes) {
        //创建一个ArrayList
        ArrayList<Node> nodes = new ArrayList<Node>();
        //遍历bytes,统计每个byte出现的次数 -> map[key,value]
        Map<Byte, Integer> counts = new HashMap<Byte, Integer>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        //把每个键值对转成一个Node对象，并加入到nodes集合
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    //通过List，创建对应的赫夫曼树
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //创建一颗新的二叉树,它的根节点没有data,只有权值
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
    //编写一个方法，将字符串对应的byte[]数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码 压缩后的byte[]

    /**
     * @param bytes        这是原始的字符串对应的byte[]
     * @param huffmanCodes 生成的赫夫曼编码map
     * @return 返回赫夫曼编码处理后的byte[]
     * 举例：String content = "i like like like java do you like a java"; =>  byte[] contentBytes = content.getBytes();
     * 返回的是字符串"1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100"
     * 对应的byte[] huffmanCodeBytes   即8位对应一个byte，放入到huffmanCodeBytes
     * 转换过程中，符号位不变
     * huffmanCodeBytes[0] = 10101000(补码) => byte[推导10101000 => 10101000-1 => 10100111(反码) => 11011000 => -88]
     * huffmanCodeBytes[0] = -88
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        //1.利用huffmanCodes将bytes转成赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历bytes数组
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
//        System.out.println("测试stringBuilder=" + stringBuilder.toString());
        //将"10101000101111111100100010..." 转成byte[]
        //统计返回byte[] huffmanCodeBytes 长度
        //一句话代码 int len = (stringBuilder.length()+7)/8;
        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        //创建存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;//记录是第几个byte
        for (int i = 0; i < stringBuilder.length(); i += 8) {//因为是每8位对应一个byte，所有步长+8
            String strByte;
            if (i + 8 > stringBuilder.length()) {//不够8位
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            //将strByte转成一个byte，放入到huffmanCodeBytes
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    //生成赫夫曼树对应的赫夫曼编码,将生成的赫夫曼编码放在Map<Byte,String>形式
    //32->01 97->100 100->11000
    static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
    //在生成赫夫曼编码表示，需要去拼接路径，定义一个StringBuilder,存储某叶子节点的路径
    static StringBuilder stringBuilder = new StringBuilder();

    //为了调用方便，我们重载getCodes
    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        //处理root
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    /**
     * 功能：将传入的node节点的所有叶子节点的赫夫曼编码得到，并放入到huffmanCodes集合中
     *
     * @param node          传入节点
     * @param code          路径：左子节点是0，右子节点是1
     * @param stringBuilder 是用于拼接路径
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //将code加入到stringBuilder2
        stringBuilder2.append(code);
        if (node != null) {//如果node == null 不处理
            //判断当前node是叶子节点还是非叶子节点
            if (node.data == null) {//非叶子节点
                //递归处理
                //向左递归
                getCodes(node.left, "0", stringBuilder2);
                //向右递归
                getCodes(node.right, "1", stringBuilder2);
            } else {//说明是一个叶子节点
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }
}

//创建Node，保存数据和权值
class Node implements Comparable<Node> {
    Byte data;//存放数据本身，比如'a'=> 97  ' '=>32
    int weight;//权值，表示字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
