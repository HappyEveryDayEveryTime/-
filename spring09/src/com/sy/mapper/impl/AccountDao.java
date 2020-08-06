package com.sy.mapper.impl;

import com.sy.mapper.AccountDaoI;
import com.sy.pojo.Account;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Title: UserDao
 * @Description:
 * @Auther:
 * @Version: 1.0
 * @create 2020/6/26 0026 19:16
 */
public class AccountDao implements AccountDaoI {


    private JdbcTemplate jdbcTemplate;



    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account findAccountById(Integer id) {
        String sql = "select * from t_account where id = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Account>() {
            @Override
            public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
                Account accountObj =null;
                if(rs.next()) {
                    Integer id = rs.getInt("id");
                    String name  = rs.getString("name");
                    Double account  = rs.getDouble("account");
                    accountObj =new Account(id,name,account);

                }
                return accountObj;
            }
        }, id);
    }

    @Override
    public Account findAccountByName(String name) {
        String sql = "select * from t_account where name = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Account>() {
            @Override
            public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
                Account accountObj =null;
                if(rs.next()) {
                    Integer id = rs.getInt("id");
                    String name  = rs.getString("name");
                    Double account  = rs.getDouble("account");
                    accountObj =new Account(id,name,account);

                }
                return accountObj;
            }
        }, name);
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("UPDATE t_account SET NAME=?,account=? WHERE id = ?",
                account.getName(),account.getAccount(),account.getId());

    }
}
