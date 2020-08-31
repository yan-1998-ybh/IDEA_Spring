package com.itybh.ui;

import com.itybh.factory.BeanFactory;
import com.itybh.service.IAccountService;
import com.itybh.service.impl.AccoutServiceImpl;

/**
 * 模拟一个表层，用于调用业务层 servlet
 */
public class Client {
    public static void main(String[] args) {
       // IAccountService as =new AccountServiceImpl();
        for(int i=0;i<5;i++){}
        IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
        System.out.println(as);
        as.saveAccount();
    }
}
