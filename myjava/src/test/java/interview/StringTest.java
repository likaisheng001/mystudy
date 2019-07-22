package interview;

import org.junit.Test;

/**
 * Created by Administrator on 2019/7/22.
 */
public class StringTest {
    //编码：请使用Java语言编写一个函数，实现"判断输入的字符串是否为数字"
    //"007" "7" 浮点数
    //编写方法的三步：检查，处理，返回
    /**
     * 判断输入的是否是数字(整数or小数)
     * 1.是否是整数 这种情况比较简单,可以独立封装一个方法来做
     * 2.是否是小数
     * 备注：这样设计的方法才满足扩展性
     * @param str
     * @return
     */
    public static boolean checkNum(String str){
        boolean flag = true;
        if (!checkInteger(str)){
            if (!checkFloat(str)){
                flag = false;
            }
        }
        //筛掉007这种情况
        if (flag && str.length() > 1 && str.charAt(0) == '0'){
            flag = false;
        }
        return flag;
    }
    public static boolean checkInteger(String str){
        boolean flag = true;
        if (str.isEmpty()){
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9'){
                flag = false;
            }
        }
        return flag;
    }
    //判断是否是浮点数
    public static boolean checkFloat(String str){
        boolean flag = true;
        if (str.isEmpty() || str.indexOf(".") == -1){
            return false;
        }
        String[] strArr = str.split("\\.");
        if (strArr.length != 2){
            flag = false;
        }else {
            if (!checkInteger(strArr[0]) || !checkInteger(strArr[1])){
                flag = false;
            }
        }
        return flag;
    }
    @Test
    public void test01(){
        String str = "111011.000";
        System.out.println("是否是数字:"+checkNum(str));
    }
}
