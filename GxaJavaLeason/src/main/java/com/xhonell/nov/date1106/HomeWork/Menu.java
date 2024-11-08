package com.xhonell.nov.date1106.HomeWork;

import com.xhonell.util.JDBCUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import static com.xhonell.oct.date1015.Shopping.scanner;

/**
 * <p>Project:JavaProject - Menu
 * <p>POWER by xhonell on 2024-11-06 18:01
 * <p>description：测试数据库的链接
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class Menu {
    JDBCUtils jdbcUtils = new JDBCUtils();

    /**
     * 登录方法
     */
    public void login() {
        System.out.print("请输入您要登录的用户名称：");
        String userName = scanner.next();
        System.out.print("请输入您要登录的密码：");
        String password = scanner.next();
        Object[] user = new Object[]{userName, password};
        String sql = "SELECT user_name, user_password FROM tb_user WHERE user_name = ? AND  user_password = ?";
        List<Map<String, Object>> select = jdbcUtils.select(sql, user);
        if (select.size() == 1) {
            System.out.println("登录成功");

            indexAfterLogin(user);
        } else {
            System.out.println("登录失败，请重新尝试！");
            login();
        }
    }

    /**
     * 注册方法
     */
    public void register() {
        System.out.print("请输入您的用户名称：");
        String userName = scanner.next();
        System.out.print("请输入您的密码：");
        String password = scanner.next();
        Object[] user = new Object[]{userName, password};
        String sql = "INSERT INTO tb_user (user_name, user_password) VALUES (?, ?);";
        int update = jdbcUtils.update(sql, user);
        if (update >= 1) {
            System.out.println("注册成功！");
            Main.index();
        } else {
            System.out.println("注册失败,请重新尝试");
            Main.index();
        }
    }

    /**
     * 主页
     *
     * @param user
     */
    public void indexAfterLogin(Object[] user) {
        System.out.println("请输入你要进行的操作：\n\t1、查询所有用户\n\t2、修改账户信息\n\t3、注销账户");
        System.out.print("我的选择是：");
        Integer chooseByte = scanner.nextInt();
        while (true) {
            switch (chooseByte) {
                case 1:
                    selectAllUser(user);
                    break;
                case 2:
                    updateUser(user);
                    break;
                case 3:
                    deleteUser(user);
                    break;
            }
        }
    }

    /**
     * 查询方法
     *
     * @param user
     */
    public void selectAllUser(Object[] user) {
        System.out.println("所有用户如下：");
        String sql = "SELECT user_id, user_name, user_sex, user_phone FROM tb_user";
        PreparedStatement statement = jdbcUtils.getStatement(sql);
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("user_id");
                String name = resultSet.getString("user_name");
                String sex = resultSet.getString("user_sex");
                Integer phone = resultSet.getInt("user_phone");

                System.out.println("user_id: " + id + "\tuser_name: " + name + "\tuser_sex: " + sex + "\tuser_phone: " + phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.close();
            indexAfterLogin(user);
        }
    }

    /**
     * 修改方法
     *
     * @param user
     */
    public void updateUser(Object[] user) {
        Object[] updateUser = new Object[2];
        System.out.println("请依次输入你要修改的值：性别、电话");
        for (int i = 0; i < 2; i++) {
            updateUser[i] = scanner.next();
        }
        String sql = "UPDATE tb_user SET user_sex = ?, user_phone = ? WHERE user_name = '" + user[0] + "'";
        int update = jdbcUtils.update(sql, updateUser);
        if (update >= 1) {
            System.out.println("修改成功！");
            indexAfterLogin(user);
        } else {
            System.out.println("修改失败，请重新尝试");
            updateUser(user);
        }
    }

    /**
     * 删除方法
     *
     * @param user
     */
    public void deleteUser(Object[] user) {
        String sql = "DELETE FROM tb_user WHERE user_name = ? AND user_password = ?";
        int update = jdbcUtils.update(sql, user);
        if (update >= 1) {
            System.out.println("删除成功");
            Main.index();
        } else {
            System.out.println("删除失败，请重新尝试！");
            updateUser(user);
        }
    }
}
