package com.itybh.jdbctemplate;

import com.itybh.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTemplate的CRUD操作
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext as = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jt = as.getBean("jdbcTemplate",JdbcTemplate.class);
        //3.执行操作
        //保存
//        jt.update("insert into useraccount(name,money)values(?,?)","eee",3333f);
        //更新
//        jt.update("update useraccount set name=?,money=? where id=?","test",4567,7);
        //删除
//        jt.update("delete from useraccount where id=?",8);
        //查询所有
//        List<Account>accounts = jt.query("select * from useraccount where money>?",new AccountRomMapper(),1000);
//        List<Account>accounts = jt.query("select * from useraccount where money>?",new BeanPropertyRowMapper<Account>(Account.class),900);
//        for (Account account:accounts){
//            System.out.println(account);
//        }
        //查询一个

//        List<Account>accounts = jt.query("select * from useraccount where id=?",new BeanPropertyRowMapper<Account>(Account.class),1);
//            System.out.println(accounts.isEmpty()?"没有内容":accounts.get(0));

        //查询返回一行一列(使用聚合函数，但不加group by子句)
        Long count = jt.queryForObject("select count(*) from useraccount where money > ?",Long.class,1000f);
        System.out.println(count);
    }
}



class AccountRomMapper implements RowMapper<Account>{
    /**
     * 把结果集中的数据封装到Account中，然后Spring把每个Account加到集合中
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getFloat("money"));
        return account;
    }
}
