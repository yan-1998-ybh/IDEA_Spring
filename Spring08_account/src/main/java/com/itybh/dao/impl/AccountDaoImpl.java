package com.itybh.dao.impl;

import com.itybh.dao.IAccountDao;
import com.itybh.domain.Account;
import com.itybh.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * 账户的持久成实现类
 */
public class AccountDaoImpl implements IAccountDao {

    private QueryRunner runner;
    private ConnectionUtils connectionUtils;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    @Override
    public List<Account> findAllAccount() {
       try{
           return runner.query(connectionUtils.getThreadConnection(),"select *from useraccount " ,new BeanListHandler<Account>(Account.class));
       }catch (Exception e){
           throw new RuntimeException(e);
       }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try{
            return runner.query(connectionUtils.getThreadConnection(),"select *from useraccount where id = ? " ,new BeanHandler<Account>(Account.class),accountId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account acc) {
        try{
             runner.update(connectionUtils.getThreadConnection(),"insert into useraccount(name,money) value(?,?)" ,acc.getName(),acc.getMoney());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account acc) {
        try{
            runner.update(connectionUtils.getThreadConnection(),"update useraccount set name=?,money=? where id=?" ,acc.getName(),acc.getMoney(),acc.getId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try{
            runner.update(connectionUtils.getThreadConnection(),"delete from useraccount where id=?" ,accountId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountByName(String accountName) {
        try{
            List<Account> accounts = runner.query(connectionUtils.getThreadConnection(),"select *from useraccount where name = ? " ,new BeanListHandler<Account>(Account.class),accountName);
            if (accounts == null || accounts.size() == 0){
                return null;
            }
            if (accounts.size() > 1){
                throw new RuntimeException("结果集不唯一，数据有问题");
            }
            return accounts.get(0);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
