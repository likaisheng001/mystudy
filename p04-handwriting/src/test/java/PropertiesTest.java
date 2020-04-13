/**
 * Created by My on 2019-12-22.
 */

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:49:08 2019-12-22
 * @Modified By:
 */
public class PropertiesTest {
    Properties properties = new Properties();

    /**
     *
     *
     */
    // 项目下的资源，可以通过类加载器加载
    // Properties本质是一个HashTable
    // TODO 有空好好学习下HashTable和Properteis
    @Test
    public void testLoadProperties(){
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("spring300_v1/application.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("properties=" + properties);
    }
}
