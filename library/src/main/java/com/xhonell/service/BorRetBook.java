package com.xhonell.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.xhonell.MainApp.jdbc;

/**
 * <p>Project:JavaProject - BorrowBook
 * <p>POWER by xhonell on 2024-11-09 11:01
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class BorRetBook {
    /**
     * 从图书馆借书
     *
     * @param bokId 图书ID
     * @return 如果图书已被借出则返回false，否则将图书状态更新为“借阅”并返回true
     * @throws SQLException 如果在执行SQL语句时发生错误，则抛出此异常
     */
    public boolean borrowBook(Long bokId) {
        String sql = "select bok_statu from tb_books where bok_id=?";
        PreparedStatement statument = jdbc.getStatument(sql);
        try {
            statument.setLong(1, bokId);
            ResultSet resultSet = statument.executeQuery();
            if (resultSet.next()) {
                String statu = resultSet.getString("bok_statu");
                if ("借阅".equals(statu)) {
                    System.out.println("该书已被借出");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        sql = "update tb_books set bok_statu = '借阅' where bok_id=?";
        statument = jdbc.getStatument(sql);
        try {
            statument.setLong(1, bokId);
            int i = statument.executeUpdate();
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将书籍状态更新为“在库”
     *
     * @param bokId 书籍的ID
     * @return 如果更新成功返回true，否则返回false
     * @throws SQLException 如果执行SQL时发生异常
     */
    public boolean returnBook(Long bokId) {
        String sql = "update tb_books set bok_statu = '在库' where bok_id=?";
        PreparedStatement statument = jdbc.getStatument(sql);
        try {
            statument.setLong(1, bokId);
            int i = statument.executeUpdate();
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
