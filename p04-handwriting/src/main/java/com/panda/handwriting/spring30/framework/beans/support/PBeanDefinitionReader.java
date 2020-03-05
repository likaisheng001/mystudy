package com.panda.handwriting.spring30.framework.beans.support;/**
 * Created by My on 2019-12-28.
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:27:42 2019-12-28
 * @Modified By:
 */
public class PBeanDefinitionReader {
    private List<String> registryBeanClasses = new ArrayList<String>();
    private Properties config = new Properties();

    private final String SCAN_PACKAGE = "scanPackage";

    public PBeanDefinitionReader(String... locations) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(locations[0].replace("classpath:", ""));
        try {
            config.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is){
                try {
                    is.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        doScanner(config.getProperty(SCAN_PACKAGE));
    }

    private void doScanner(String scanPackage) {
        // com.panda.demo 转换为文件路径
        // FIXME 此处存在路径转换问题

    }
}
