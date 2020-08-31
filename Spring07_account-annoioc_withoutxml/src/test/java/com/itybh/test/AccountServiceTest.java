package com.itybh.test;

import com.itybh.domain.Account;
import com.itybh.service.IAccountService;
import config.JdbcConfig;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.applet.AppletContext;
import java.util.List;

/**
 * 使用junit单元测试：测试我们的配置
 * Spring整合junit的配置
 *      1.导入Spring整合junit的jar（坐标）
 *      2.使用Junit提供的一个注解把原有的main方法替换了，替换成Spring提供的
 *            @Runwith
 *      3.告知spring的运行器，Spring和IOC创建是基于xml还是注解的，并说明位置
 *          @ContextConfiguration
 *                  locations:指定xml文件的位置，加上classpath关键字，表示在类路径下
 *                  classes：指定在注解类所在的位置
 *      当我们使用 Spring5.x版泵的时候，要求junit的jar必须在4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {
    @Autowired
    private IAccountService as;
    @Test
    public void testFindAll() {
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for(Account account:accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {

        //3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("test anno");
        account.setMoney(12345f);
        //3.执行方法
        as.saveAccount(account);
    }

    @Test
    public void testUpdate() {

        //3.执行方法
        Account account = as.findAccountById(4);
        account.setMoney(23456f);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        //3.执行方法
        as.deleteAccount(4);

    }
}
