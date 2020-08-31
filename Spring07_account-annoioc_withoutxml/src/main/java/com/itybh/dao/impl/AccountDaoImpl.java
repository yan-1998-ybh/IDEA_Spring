package com.itybh.dao.impl;

import com.itybh.dao.IAccountDao;
import com.itybh.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户的持久成实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner runner;


    @Override
    public List<Account> findAllAccount() {
       try{
           return runner.query("select *from useraccount " ,new BeanListHandler<Account>(Account.class));
       }catch (Exception e){
           throw new RuntimeException(e);
       }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try{
            return runner.query("select *from useraccount where id = ? " ,new BeanHandler<Account>(Account.class),accountId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account acc) {
        try{
             runner.update("insert into useraccount(name,money) value(?,?)" ,acc.getName(),acc.getMoney());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account acc) {
        try{
            runner.update("update useraccount set name=?,money=? where id=?" ,acc.getName(),acc.getMoney(),acc.getId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try{
            runner.update("delete from useraccount where id=?" ,accountId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
