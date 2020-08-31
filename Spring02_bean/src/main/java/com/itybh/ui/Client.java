package com.itybh.ui;



import com.itybh.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * 模拟一个表层，用于调用业务层 servlet
 */
public class Client {
    /**

     * @param args
     */
    public static void main(String[] args) {
        //1.或缺核心容器对象
//        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        //多态，父类对象是借口
        ClassPathXmlApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
//        IAccountService as2 = (IAccountService) ac.getBean("accountService");

//        System.out.println(as1 == as2);

        as.saveAccount();
        //手动关闭容器
        ac.close();

    }



}
