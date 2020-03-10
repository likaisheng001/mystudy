package com.panda.study.designmodel_gp.decorator.goodhomework02;/**
 * Created by My on 2020-03-10.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Likaisheng
 * @Description: 定义导航项目实体
 * @Date: Created in 10:31:45 2020-03-10
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Function implements Comparable<Function> {
    private Long id; // 用于导航栏间排序
    private String name;
    private String routePath;

    @Override
    public int compareTo(Function o) {
        return id.compareTo(o.id);
    }
}
