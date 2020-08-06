package com.sy.mapper;

import com.sy.pojo.Account;

/**
 * @Title: UserDaoI
 * @Description:
 * @Auther:
 * @Version: 1.0
 * @create 2020/6/26 0026 19:16
 */
public interface AccountDaoI {

    /**
     * 根据 id 查询账户信息
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 根据名称查询账户信息
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 更新账户信息
     * @param account
     */
    void updateAccount(Account account);

}
