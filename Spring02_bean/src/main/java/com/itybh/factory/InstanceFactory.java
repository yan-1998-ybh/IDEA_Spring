package com.itybh.factory;

import com.itybh.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类（该类可能是存在于java包中的，我们无法通过修改源码的方式来提供默认参数构造）
 */
public class InstanceFactory {
    public AccountServiceImpl getAccountService(){
        return new AccountServiceImpl();
    }
}
