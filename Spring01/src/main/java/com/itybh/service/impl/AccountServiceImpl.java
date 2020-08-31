package com.itybh.service.impl;

import com.itybh.service.IAccountService;
import com.itybh.dao.IAccountDao;
import com.itybh.dao.impl.AccountDaoImpl;

/**
 * 账户的业务实现类
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = new AccountDaoImpl();

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }


    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
