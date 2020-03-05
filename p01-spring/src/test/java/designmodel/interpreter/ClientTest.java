package designmodel.interpreter;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Administrator on 2019/9/3.
 */
public class ClientTest {
    public static void main(String[] args) throws IOException {
        String expStr = getExpStr();
        HashMap<String ,Integer> var = getValue(expStr);
        Calulator calulator = new Calulator(expStr);
        System.out.println("运算结果："+ expStr + "=" + calulator.run(var));
    }
    public static String getExpStr() throws IOException {
        System.out.println("请输入表达式:");
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }
    //获得值映射
    public static HashMap<String,Integer> getValue(String expStr) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        for(char ch:expStr.toCharArray()){
            if (ch != '+' && ch != '-'){
                if (!map.containsKey(String.valueOf(ch))){
                    System.out.print("请输入" + String.valueOf(ch) + "的值:");
                   String in = (new BufferedReader( new InputStreamReader(System.in)).readLine());
                   map.put(String.valueOf(ch),Integer.valueOf(in));
                }
            }
        }
        return map;
    }
}
