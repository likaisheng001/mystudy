/**
 * Created by My on 2019-12-18.
 */

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 09:39:39 2019-12-18
 * @Modified By:
 */
public class RegexTest {
    @Test
    public void test01(){
        //X*    X,zero or more times
        Pattern p = Pattern.compile("a*b");
        Matcher m = p.matcher("aaaaab");
        boolean b = m.matches();
        System.out.println(b);
    }

    @Test
    public void test02(){
        boolean b = Pattern.matches("a*b","aaaaab");
        System.out.println(b);
    }

    @Test
    public void test03(){
        String str = "aaaaab";
        str = str.replaceAll("a*b","ok");
        System.out.println("str="+str);
    }

    @Test
    public void test04(){
        //将字符串中的点替换掉
        String str = "com.panda.controller";
        // .是特殊字符，使用前需要转义；而\也是特殊字符，在使用前也需要转义，所以写作"\\."
        //str = str.replaceAll("\\.", "\\");  //这种写法，有的时候可以，有的时候不可以
        str = str.replaceAll("\\.", Matcher.quoteReplacement(File.separator));
        System.out.println("str="+str);
    }
}
