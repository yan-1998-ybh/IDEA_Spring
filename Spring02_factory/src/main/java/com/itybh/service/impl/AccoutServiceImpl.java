package com.itybh.service.impl;

import com.itybh.factory.BeanFactory;
import com.itybh.service.IAccountService;
import com.itybh.dao.IAccountDao;
import com.itybh.dao.impl.AccountDaoImpl;

/**
 * 账户的业务实现类
 */
public class AccoutServiceImpl implements IAccountService {
//    private IAccountDao accountDao = new AccountDaoImpl();
private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    @Override
    public void saveAccount() {
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
