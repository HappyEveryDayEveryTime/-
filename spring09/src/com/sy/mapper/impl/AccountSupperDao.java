package com.sy.mapper.impl;

import com.sy.mapper.AccountDaoI;
import com.sy.pojo.Account;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Title: AccountSupperDao
 * @Description:
 * @Auther:
 * @Version: 1.0
 * @create 2020/6/27 0027 00:09
 */
public class AccountSupperDao extends JdbcDaoSupport implements AccountDaoI {



    @Override
    public Account findAccountById(Integer id) {
        String sql = "select * from t_account where id = ?";
        return super.getJdbcTemplate().query(sql, new ResultSetExtractor<Account>() {
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
        return super.getJdbcTemplate().query(sql, new ResultSetExtractor<Account>() {
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
        super.getJdbcTemplate().update("UPDATE t_account SET NAME=?,account=? WHERE id = ?",
                account.getName(),account.getAccount(),account.getId());

    }
}
