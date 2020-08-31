package com.itybh.service.impl;

import com.itybh.dao.IAccountDao;
import com.itybh.domain.Account;
import com.itybh.service.IAccountService;
/**
 * 账户的业务层实现类
 *
 * 事务控制应该都是在业务层
 */

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {

        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        accountDao.updateAccount(source);
//        int i=1/0;
        accountDao.updateAccount(target);

    }
}
