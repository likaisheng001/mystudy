package com.panda.spring.test;/**
 * Created by My on 2019-12-18.
 */

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 09:39:39 2019-12-18
 * @Modified By:
 */
public class RegexTest {
    public static void main(String[] args) {
        /*//X*    X,zero or more times
        Pattern p = Pattern.compile("a*b");
        Matcher m = p.matcher("aaaaab");
        boolean b = m.matches();
        System.out.println(b);*/

        boolean b = Pattern.matches("a*b","aaaaab");
        System.out.println(b);

        /*String str = "aaaaab";
        str = str.replaceAll("a*b","ok");
        System.out.println("str="+str);*/

        /*//将字符串中的点替换掉
        String str = "com.panda.controller";
        // .是特殊字符，使用前需要转义；而\也是特殊字符，在使用前也需要转义，所以写作"\\."
        str = str.replaceAll("\\.","\\");
        System.out.println("str="+str);*/
    }

}
