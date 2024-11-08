package com.xhonell.nov.date1106;

import com.mysql.cj.jdbc.Driver;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.sql.*;

/**
 * <p>Project:JavaProject - SqlJDBC
 * <p>POWER by xhonell on 2024-11-06 15:57
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class SqlJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/db_test";
        String user = "root";
        String password = "@Hx1234568";

        /*注册驱动*/
        Class.forName("com.mysql.cj.jdbc.Driver");

        /*创建连接*/
        Connection connection = DriverManager.getConnection(url, user, password);

        /*获取执行sql的语句执行语句*/
        Statement statement = connection.createStatement();

        /*编写sql语句,并执行，以及接受返回的结果集*/
        String sql = "select * from student";
        ResultSet resultSet = statement.executeQuery(sql);

        /*处理结果，遍历结果集*/
        while (resultSet.next()) {
            int stu_id = resultSet.getInt("stu_id");
            int stu_age = resultSet.getInt("stu_age");
            String stu_name = resultSet.getString("stu_name");

            System.out.println(stu_id + "\t" + stu_age + "\t" + stu_name);
        }

        /*释放资源*/
        resultSet.close();
        statement.close();
        connection.close();
    }
}

