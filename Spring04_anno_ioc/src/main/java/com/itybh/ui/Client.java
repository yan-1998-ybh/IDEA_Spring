package com.itybh.ui;


import com.itybh.dao.IAccountDao;
import com.itybh.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * 模拟一个表层，用于调用业务层 servlet
 */
public class Client {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.或缺核心容器对象
      //  ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
//        IAccountService as2 = (IAccountService) ac.getBean("accountService");
//        System.out.println(as1 ==as2);
//
//        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);
//        System.out.println(adao);

                as.saveAccount();
                ac.close();

    }



}
