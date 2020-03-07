package com.panda.study.designmodel_gp.decorator.goodhomework;/**
 * Created by My on 2020-03-07.
 */

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:21:31 2020-03-07
 * @Modified By:
 */
@Data
@Accessors(chain = true)
public class User {
    private String userName;
}
