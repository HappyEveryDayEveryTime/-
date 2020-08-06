package com.sy.test;

import com.sy.mapper.AccountDaoI;
import com.sy.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Title: JdbcSupper
 * @Description:
 * @Auther:
 * @Version: 1.0
 * @create 2020/6/27 0027 00:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class JdbcSupperDaoTest {


    @Autowired
    private AccountDaoI accountSupperDao;

    @Test
    public void func01() {
        Account account = accountSupperDao.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void func02() {
        Account account = accountSupperDao.findAccountByName("小红");
        System.out.println(account);
    }

    @Test
    public void func03() {
        Account account = new Account(1,"吉姆",3000.0);
        accountSupperDao.updateAccount(account);
    }
}
