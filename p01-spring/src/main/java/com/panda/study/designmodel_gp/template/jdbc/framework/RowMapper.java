package com.panda.study.designmodel_gp.template.jdbc.framework;/**
 * Created by My on 2020-03-27.
 */

import java.sql.ResultSet;

/**
 * @Author: Likaisheng
 * @Description: 供给用户，用于结果集映射
 * @Date: Created in 16:31:40 2020-03-27
 * @Modified By:
 */
public interface RowMapper<T> {
    T mapRow(ResultSet rs, int rowNum) throws Exception;
}
