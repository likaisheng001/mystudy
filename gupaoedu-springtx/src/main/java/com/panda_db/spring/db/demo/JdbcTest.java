package com.panda_db.spring.db.demo;


import com.panda_db.spring.db.entity.Member;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 22:16:24 2019-12-19
 * @Modified By:
 */
public class JdbcTest {
    public static void main(String[] args) {
            Member condition = new Member();
            condition.setName("Mic");
            condition.setAge(20);
        List<?> result = select(condition);
        System.out.println(Arrays.toString(result.toArray()));
    }

    private static List<?> select(Object condition){
        Class<?> entityClass = condition.getClass();

        List<Object> result = new ArrayList<Object>();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            //1. 加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //2. 建立连接
            con = DriverManager.getConnection("jdbc:mysql://114.67.94.190:3306/springtx?characterEncoding=UTF-8&rewriteBatchedStatements=true","root","root");

            //mapper保存 列名和字段名的关系
            Map<String,String> mapper = new HashMap<String,String>();
            Map<String,String> getColumnNameByFieldName = new HashMap<String,String>();
            Field[] fields = entityClass.getDeclaredFields();
            for (Field field : fields){
                field.setAccessible(true);
                String fieldName = field.getName();
                if (field.isAnnotationPresent(Column.class)) {
                    Column column = field.getAnnotation(Column.class);
                    mapper.put(column.name(),fieldName);
                    getColumnNameByFieldName.put(fieldName,column.name());
                }else {
                    mapper.put(fieldName,fieldName);
                    getColumnNameByFieldName.put(fieldName,fieldName);
                }
            }
            //3. 创建语句集
            Table table = entityClass.getAnnotation(Table.class);
            String sql = "select * from " + table.name();
            StringBuffer where = new StringBuffer(" where 1=1 ");
            for (Field field : fields){
                Object val = field.get(condition);
                if (null != val){
                    if (String.class == field.getType()){
                        where.append(" and " + getColumnNameByFieldName.get(field.getName()) + " = '" + val + "'");
                    }else{
                        where.append(" and " + getColumnNameByFieldName.get(field.getName()) + " = " + val + "");
                    }
                    //其他的，在这里就不一一列举了，下半截我们手写ORM框架会完善
                }
            }

            pstm = con.prepareStatement(sql + where.toString());
            System.out.println(sql+where.toString());

            //4. 执行语句集
            rs = pstm.executeQuery();
            while (rs.next()){

                Object instance = entityClass.newInstance();
                int columCounts = rs.getMetaData().getColumnCount();
                for (int i = 1; i <= columCounts; i++){
                    //从rs中取得当前这个游标下的列名
                    String columnName = rs.getMetaData().getColumnName(i);
                    //有可能是私有的
                    Field field = entityClass.getDeclaredField(mapper.get(columnName));
                    field.setAccessible(true);
                    field.set(instance,rs.getObject(columnName));
                }

                /*//把这段代码封装
                Member m = new Member();
                m.setId(rs.getLong("id"));
                m.setAge(rs.getInt("age"));
                m.setAddr(rs.getString("addr"));
                m.setName(rs.getString("name"));*/
                result.add(instance);
            }
            //5. 获取结果集
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //6. 关闭结果集、关闭语句集、关闭连接
            try {
                rs.close();
                pstm.close();
                con.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
