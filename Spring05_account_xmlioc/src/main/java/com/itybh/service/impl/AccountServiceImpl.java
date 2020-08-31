package com.itybh.service.impl;

import com.itybh.dao.IAccountDao;
import com.itybh.domain.Account;
import com.itybh.service.IAccountService;

import java.io.Serializable;
import java.util.List;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account acc) {
        accountDao.saveAccount(acc);
    }

    @Override
    public void updateAccount(Account acc) {
        accountDao.updateAccount(acc);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }
}
