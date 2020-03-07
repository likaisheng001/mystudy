package com.panda.study.designmodel_gp.decorator.logger;/**
 * Created by My on 2020-03-07.
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.*;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:36:48 2020-03-07
 * @Modified By:
 */
public class Test {
    //private static final Logger logger = LoggerFactory.getLogger(Test.class);
    private static final Logger logger = JsonLoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        logger.error("系统错误");

        try {
            InputStream in = new FileInputStream("");
            BufferedInputStream bis = new BufferedInputStream(in);

            bis.read();
            bis.close();

            BufferedReader br = new BufferedReader(new FileReader(""));
            br.readLine();

            BufferedReader bs = new BufferedReader(new StringReader(""));
            bs.readLine();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
