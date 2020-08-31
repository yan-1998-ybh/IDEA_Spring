package com.itybh.service.impl;

import com.itybh.dao.IAccountDao;
import com.itybh.domain.Account;
import com.itybh.service.IAccountService;
import com.itybh.utils.TransactionManager;

import java.io.Serializable;
import java.util.List;

/**
 * 账户的业务层实现类
 *
 * 实物控制应该都是在业务层
 */
public class AccountServiceImpl_OLD implements IAccountService {
    private IAccountDao accountDao;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
          List<Account> accounts = accountDao.findAllAccount();
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return accounts;
        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放资源
            txManager.release();
        }

    }

    @Override
    public Account findAccountById(Integer accountId) {
            try{
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            Account accounts = accountDao.findAccountById(accountId);
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return accounts;
        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
                throw new RuntimeException(e);
        }finally {
            //6.释放资源
            txManager.release();
        }

    }

    @Override
    public void saveAccount(Account acc) {
        try{
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
             accountDao.saveAccount(acc);
            //3.提交事务
            txManager.commit();

        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();

        }finally {
            //6.释放资源
            txManager.release();
        }
    }

    @Override
    public void updateAccount(Account acc) {
        try{
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
             accountDao.updateAccount(acc);
            //3.提交事务
            txManager.commit();
        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();

        }finally {
            //6.释放资源
            txManager.release();
        }

    }

    @Override
    public void deleteAccount(Integer accountId) {
        try{
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(accountId);
            //3.提交事务
            txManager.commit();

        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();

        }finally {
            //6.释放资源
            txManager.release();
        }


    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作

            //2.1.根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            //2.2.根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            //2.3.转出账户减钱
            source.setMoney(source.getMoney()-money);
            //2.4.转入账户加钱
            target.setMoney(target.getMoney()+money);
            //2.5.更新转出账户
            accountDao.updateAccount(source);

            int i=1/0;

            //2.6.更新转入账户
            accountDao.updateAccount(target);
            //3.提交事务
            txManager.commit();
        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
            e.printStackTrace();
        }finally {
            //6.释放资源
            txManager.release();
        }

    }
}
