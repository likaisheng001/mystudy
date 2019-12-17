package com.panda.spring2.framework.aop.config;/**
 * Created by My on 2019-12-17.
 */

import lombok.Data;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:29:56 2019-12-17
 * @Modified By:
 */
@Data
public class GPAopConfig {
    private String pointCut;
    private String aspectBefore;
    private String aspectAfter;
    private String aspectClass;
    private String aspectAfterThrow;
    private String aspectAfterThrowingName;

}
