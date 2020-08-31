package com.itybh.jdbc;

import java.sql.*;

/**
 * 程序的耦合
 *      耦合：程序间的依赖关系
 *      包括：
 *          类之间的依赖
 *          方法间的依赖
 *       解耦：
 *          降低程序间的依赖关系
 *       实际开发中
 *             应该做到：编译器不依赖，运行时才依赖
 *        解耦的思路：
 *             第一步：使用反射机制来创建对象，而避免使用new关键字
 *             第二步：通过读取配置文件来获取要创建的对象全限定类名
 */
public class JdbcDem01 {
    public static void main(String[] args) {
        //1.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ybh?useUnicode=true&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","123456");
            //3.获取操作数据的预处理对象
           PreparedStatement pstm = con.prepareStatement("select * from account");
            //4.执行Sql，得到结果集
            ResultSet rs = pstm.executeQuery();
            //5.遍历结果集
            while (rs.next()){
                System.out.println(rs.getString("uid"));
            }
            //6.释放资源
            rs.close();
            pstm.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
