package com.panda.pattern.delegate.simple;/**
 * Created by My on 2019-12-09.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 19:49:07 2019-12-09
 * @Modified By:
 */
public class Leader {
    //Leader要预先知道每个员工的特长、特征、分发任务
    private Map<String,IEmployee> register = new HashMap<String,IEmployee>();

    public Leader(){
        register.put("加密",new EmployeeA());
        register.put("架构",new EmployeeB());
    }

    public void doing(String command){
        register.get(command).doing(command);
    }
}
