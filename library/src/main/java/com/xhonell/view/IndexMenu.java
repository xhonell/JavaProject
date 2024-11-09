package com.xhonell.view;

import com.xhonell.util.JDBCMethod;
import com.xhonell.entity.TbLibrarian;
import com.xhonell.exception.BizException;
import com.xhonell.exception.BizExceptionCode;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.xhonell.MainApp.jdbc;
import static com.xhonell.view.Index.scanner;

/**
 * <p>Project:JavaProject - menu
 * <p>POWER by xhonell on 2024-11-08 12:55
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class IndexMenu {
    /**
     * 显示菜单并处理用户选择的操作
     */
    public void menu() {
        while (true) {
            System.out.println("====== 菜单界面 ======");
            System.out.println("请选择您要进行的操作：\n\t1、添加管理员\n\t" +
                    "2、修改管理员信息\n\t3、删除管理员\n\t4、查询所有管理员\n\t5、退出系统");
            System.out.print("请输入您的选择：");
            switch (scanner.nextInt()) {
                case 1:
                    addAdmin();
                    break;
                case 2:
                    updateAdmin();
                    break;
                case 3:
                    deleteAdmin();
                    break;
                case 4:
                    queryAllAdmin();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
    }

    /**
     * 查询所有管理员信息
     */
    private void queryAllAdmin() {
        System.out.println("======进入查询页面======");
        List<TbLibrarian> list = new ArrayList<>();
        String sql = "select lib_id, lib_name, lib_phone, lib_age, lib_role, lib_createTime from tb_librarian";
        PreparedStatement statument = jdbc.getStatument(sql);
        try {
            ResultSet resultSet = statument.executeQuery();
            while (resultSet.next()) {
                TbLibrarian tbLibrarian = new TbLibrarian();
                tbLibrarian.setLibId(resultSet.getLong("lib_id"));
                tbLibrarian.setLibName(resultSet.getString("lib_name"));
                tbLibrarian.setLibPhone(resultSet.getLong("lib_Phone"));
                tbLibrarian.setLibAge(resultSet.getInt("lib_age"));
                tbLibrarian.setLibRole(resultSet.getString("lib_role"));
                tbLibrarian.setLibCreatTime(resultSet.getTimestamp("lib_createTime"));
                list.add(tbLibrarian);
            }

            if (!list.isEmpty()) {
                list.forEach(System.out::println);
            } else {
                System.out.println("暂无数据");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            menu();
        } finally {
            jdbc.getClose();
        }

    }

    /**
     * 删除管理员
     * <p>
     * 删除指定管理员信息
     */
    private void deleteAdmin() {
        System.out.println("======进入删除页面======");
        System.out.print("请输入您要删除的管理员Id：");
        int id = scanner.nextInt();
        String sql = "delete from tb_librarian where lib_id = ?";
        PreparedStatement statument = jdbc.getStatument(sql);
        try {
            statument.setLong(1, id);
            int i = statument.executeUpdate();
            if (i > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
                menu();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            menu();
        }

    }

    /**
     * 更新管理员信息
     *
     * 此方法用于更新管理员的信息，包括姓名、手机号和年龄。
     * 首先提示用户输入要修改的管理员ID，然后根据用户输入更新数据库中的管理员信息。
     * 如果更新成功，输出“修改成功”；如果更新失败，输出“修改失败”并调用menu方法重新显示菜单。
     *
     * @throws RuntimeException 如果在执行SQL语句时发生异常，将抛出运行时异常
     */
    private void updateAdmin() {
        System.out.println("======进入修改页面======");
        System.out.print("请输入您要修改的管理员Id：");
        int id = scanner.nextInt();
        String sql = "update tb_librarian set lib_name = ?, lib_phone = ?, lib_age = ? where lib_id = ?";
        PreparedStatement statument = jdbc.getStatument(sql);
        try {
            statument.setLong(4, id);
            System.out.println("请输入您要修改的姓名：");
            statument.setString(1, scanner.next());
            System.out.println("请输入您要修改的手机号：");
            statument.setLong(2, scanner.nextLong());
            System.out.println("请输入您要修改的年龄：");
            statument.setLong(3, scanner.nextLong());

            int i = statument.executeUpdate();
            if (i > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
                menu();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 添加管理员信息
     */
    private void addAdmin() {
        System.out.println("======进入添加页面======");
        TbLibrarian tbLibrarian = new TbLibrarian();
        boolean b = true;
        while (b) {
            System.out.print("请输入您要添加的手机号：");
            b = tbLibrarian.setLibPhone(scanner.nextLong());
        }


        System.out.print("请输入您要添加的用户名：");
        tbLibrarian.setLibName(scanner.next());

        System.out.print("请输入您要添加的密码：");
        tbLibrarian.setLibPassword(scanner.next());

        System.out.print("请输入您要添加的年龄：");
        tbLibrarian.setLibAge(scanner.nextLong());

        if (new JDBCMethod().add(tbLibrarian)) {
            System.out.println("添加成功");

        } else {
            try {
                throw new BizException(BizExceptionCode.FAILED_ADD);
            } catch (BizException e) {
                System.err.println(e.getMessage());
                menu();
            }
        }

    }
}
