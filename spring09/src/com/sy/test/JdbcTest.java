package com.sy.test;

import com.sy.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Title: JdbcTest
 * @Description:
 * @Auther:
 * @Version: 1.0
 * @create 2020/6/26 0026 19:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class JdbcTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 增加操作-基本操作
     */
    @Test
    public void fun01() {

        //System.out.println(jdbcTemplate);
        String sql = "INSERT INTO t_account VALUES(null,'韩梅',10000)";
        jdbcTemplate.execute(sql);
    }

    /**
     * 增加操作-占位符操作
     */
    @Test
    public void fun02() {
        String sql = "INSERT INTO t_account VALUES(null,?,?)";
        jdbcTemplate.update(sql,"吉姆",5000.0);
    }

    /**
     * 更新操作
     */
    @Test
    public void fun03() {
        String sql = "update t_account set account = account -? where id = ?";
        jdbcTemplate.update(sql,3000,4);
    }

    /**
     * 删除操作
     */
    @Test
    public void fun04() {
        String sql = "delete from t_account where id = ?";
        jdbcTemplate.update(sql,4);
    }

    /**
     * 查询金额大于 1000
     * 查询多个操作
     */
    @Test
    public void fun05() {

        String sql = "select * from t_account where account > ?";
        List<Account>  list = jdbcTemplate.query(sql, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet rs, int i) throws SQLException {

                Integer id = rs.getInt("id");
                String name  = rs.getString("name");
                Double account  = rs.getDouble("account");
                Account accountObj =new Account(id,name,account);
                return accountObj;
            }
        }, 1000);

        System.out.println(list);

    }


    /**
     * 查询一个操作
     */
    @Test
    public void func06() {
        String sql = "select * from t_account where id = ?";
        Account account = jdbcTemplate.query(sql, new ResultSetExtractor<Account>() {
            @Override
            public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
                Account accountObj = null;

                if(rs.next()) {
                    Integer id = rs.getInt("id");
                    String name  = rs.getString("name");
                    Double account  = rs.getDouble("account");
                     accountObj =new Account(id,name,account);
                }

                return accountObj;
            }
        }, 1);
        System.out.println(account);
    }
    /**
     * 返回一行一列的操作
     */
    @Test
    public void func07() {
        String sql = "select count(id) from t_account";
        Integer count = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(count);
    }


}
