package com.xhonell.view;

import com.xhonell.entity.TbLibrarian;
import com.xhonell.exception.BizException;
import com.xhonell.exception.BizExceptionCode;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.xhonell.MainApp.jdbc;
import static com.xhonell.view.Index.scanner;

/**
 * <p>Project:JavaProject - Login
 * <p>POWER by xhonell on 2024-11-08 09:26
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class IndexChoose {
    /**
     * 登录方法
     * <p>
     * 登录系统，根据用户输入的手机号和密码验证用户身份，并根据用户角色显示相应的菜单
     */
    public void login() {
        System.out.println("======进入登录页面======");
        System.out.println("请输入您的手机号：");
        Long phone = scanner.nextLong();
        System.out.println("请输入您的密码：");
        String password = scanner.next();

        TbLibrarian tbLibrarianLogin = new TbLibrarian();
        String sql = "select lib_id, lib_phone, lib_password, lib_name, lib_age, lib_role from tb_librarian " +
                "where lib_phone = ? and lib_password = ?";
        PreparedStatement statument = jdbc.getStatument(sql);
        try {
            statument.setLong(1, phone);
            statument.setString(2, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ResultSet resultSet = statument.executeQuery();
            while (resultSet.next()) {
                tbLibrarianLogin.setLibId(resultSet.getLong("lib_id"));
                tbLibrarianLogin.setLibPhone(resultSet.getLong("lib_phone"));
                tbLibrarianLogin.setLibName(resultSet.getString("lib_name"));
                tbLibrarianLogin.setLibAge(resultSet.getLong("lib_age"));
                tbLibrarianLogin.setLibRole(resultSet.getString("lib_role"));
                tbLibrarianLogin.setLibPassword(resultSet.getString("lib_password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (tbLibrarianLogin.getLibName() != null) {
            if (tbLibrarianLogin.getLibPassword().equals(password) || tbLibrarianLogin.getLibPhone() == phone) {
                System.out.println("欢迎您，" + tbLibrarianLogin.getLibName());
                jdbc.getClose();

                if (tbLibrarianLogin.getLibRole().equals("superAdmin")) {
                    new IndexMenu().menu();
                } else if (tbLibrarianLogin.getLibRole().equals("admin")) {
                    new IndexAdmin().menu(tbLibrarianLogin);
                }
            }
        } else {
            try {
                throw new BizException(BizExceptionCode.FAILED_LOGIN);
            } catch (BizException e) {
                System.err.println(e.getMessage());
                login();
            }
        }

    }


    /**
     * 取消当前操作或任务。
     *
     * 这个方法用于取消任何正在进行的操作或任务。具体行为取决于具体的实现，
     * 例如，如果这是一个下载任务，那么调用此方法可能会停止下载。
     *
     * 注意：不是所有的操作都支持取消，如果操作不支持取消，则此方法可能不会有任何效果。
     */
    public void cancel() {
    }
}
