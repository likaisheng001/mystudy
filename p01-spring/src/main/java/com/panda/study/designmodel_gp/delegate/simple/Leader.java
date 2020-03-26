package com.panda.study.designmodel_gp.delegate.simple;/**
 * Created by My on 2020-03-26.
 */

import com.panda.study.designmodel.visitor.Man;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:28:30 2020-03-26
 * @Modified By:
 */
public class Leader implements IEmployee{
    private Map<String,IEmployee> employee = new HashMap<String,IEmployee>();

    public Leader() {
        employee.put("爬虫",new EmployeeA());
        employee.put("海报图",new EmployeeB());
    }

    @Override
    public void doing(String task) {
        if (!employee.containsKey(task)){
            System.out.println("这个任务" + task + "超出我的能力范围");
            return;
        }
        employee.get(task).doing(task);

//        通过策略模式简化此处代码
//        if ("爬虫".equals(task)){
//            new EmployeeA().doing(task);
//        }else if ("海报图".equals(task)){
//            new EmployeeB().doing(task);
//        }else {
//            System.out.println("这个任务" + task + "超出我的能力范围");
//        }
    }
}
