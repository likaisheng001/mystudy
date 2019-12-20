package com.panda_db.spring.db.dao;

import com.panda_db.spring.db.entity.Member;
import com.panda_db.spring.db.framework.BaseDaoSupport;
import com.panda_db.spring.db.framework.QueryRule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 14:06:30 2019-12-20
 * @Modified By:
 */
@Repository
public class MemberDao extends BaseDaoSupport<Member,Long> {

    JdbcTemplate jdbcTemplate;

    @Resource(name="dataSource")
    public void setDataSource(DataSource dataSource){
        //JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        super.setDataSourceReadOnly(dataSource);
        super.setDataSourceWrite(dataSource);
    }

    public List<Member> selectAll() throws Exception {
        QueryRule queryRule = QueryRule.getInstance();
        //queryRule.andEqual("name","Tom");
        queryRule.andLike("name","Tom%");
        return select(queryRule);
    }
    
    /*public List<Member> selectAll(){
        final List<Member> result = new ArrayList<>();
        String sql = "select * from t_member";

        jdbcTemplate.query(sql, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Member m = new Member();
                rs.getLong(i);
                result.add(m);
                return m;
            }
        });
        return result;
    }*/

    @Override
    protected String getPKColumn() {
        return "id";
    }
}
