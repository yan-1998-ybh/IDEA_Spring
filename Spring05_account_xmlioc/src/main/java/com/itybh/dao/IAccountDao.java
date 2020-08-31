package com.itybh.dao;

import com.itybh.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存操作
     * @param acc
     */
    void saveAccount(Account acc);

    /**
     * 更新操作
     * @param acc
     */
    void updateAccount(Account acc);

    /**
     * 删除操作
     * @param accountId
     */
    void deleteAccount(Integer accountId);
}
