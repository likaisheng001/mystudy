package com.panda.handwriting.spring30_v3.framework.aop.config;/**
 * Created by My on 2020-04-13.
 */

import lombok.Data;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:29:10 2020-04-13
 * @Modified By:
 */

@Data
public class PAopConfig {
    private String pointCut;
    private String aspectClass;
    private String aspectBefore;
    private String aspectAfter;
    private String aspectAfterThrow;
    private String aspectAfterThrowingName;
}
