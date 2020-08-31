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

    /**
     * 根据名称查账户
     * @param accountName
     * @return  如果有唯一的一个结果就返回，如果没有就返回null
     *          如果超过一个就抛异常
     */
    Account findAccountByName(String accountName);
}
