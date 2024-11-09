package com.xhonell.dao;

import com.xhonell.entity.TbBooks;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.xhonell.MainApp.jdbc;
import static com.xhonell.view.Index.scanner;

/**
 * <p>Project:JavaProject - LibraryBooksDao
 * <p>POWER by xhonell on 2024-11-09 09:32
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class LibraryBooksDao {
    /**
     * 添加图书信息
     */
    public void addBooks() {
        System.out.println("====== 添加图书信息 ======");
        TbBooks tbBooks = new TbBooks();
        String sql = "insert into tb_books(bok_name, bok_statu) values(?,?)";
        PreparedStatement statument = jdbc.getStatument(sql);
        System.out.println("请输入图书名称:");
        tbBooks.setBokName(scanner.next());
        System.out.println("请输入图书状态:");
        tbBooks.setBokStatu(scanner.next());
        try {
            statument.setString(1, tbBooks.getBokName());
            statument.setString(2, tbBooks.getBokStatu());
            int i = statument.executeUpdate();
            if (i > 0) {
                System.out.println("增加图书成功!");
            } else {
                System.out.println("增加图书失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("增加图书失败！");
        } finally {
            jdbc.getClose();
        }
    }

    /**
     * 更新图书信息
     */
    public void updateBooks() {
        System.out.println("====== 修改图书信息 ======");
        TbBooks tbBooks = new TbBooks();
        String sql = "update tb_books set bok_name=?,bok_statu=? where bok_id=?";
        System.out.println("请输入图书ID:");
        tbBooks.setBokId(scanner.nextInt());
        PreparedStatement statument = jdbc.getStatument(sql);
        System.out.println("请输入图书名称:");
        tbBooks.setBokName(scanner.next());
        System.out.println("请输入图书状态:");
        tbBooks.setBokStatu(scanner.next());

        try {
            statument.setString(1, tbBooks.getBokName());
            statument.setString(2, tbBooks.getBokStatu());
            statument.setLong(3, tbBooks.getBokId());
            int i = statument.executeUpdate();
            if (i > 0) {
                System.out.println("修改图书信息成功!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("修改图书信息失败!");
        } finally {
            jdbc.getClose();
        }
    }

    /**
     * 查询图书信息
     */
    public void selectBooks() {
        System.out.println("====== 查询图书信息 ======");
        List<TbBooks> list = new ArrayList<>();
        String sql = "select bok_id, bok_name, bok_statu from tb_books";
        PreparedStatement statument = jdbc.getStatument(sql);
        try {
            ResultSet resultSet = statument.executeQuery();
            while (resultSet.next()) {
                TbBooks tbBooks = new TbBooks();
                tbBooks.setBokId(resultSet.getLong("bok_id"));
                tbBooks.setBokName(resultSet.getString("bok_name"));
                tbBooks.setBokStatu(resultSet.getString("bok_statu"));
                list.add(tbBooks);
            }

            if (!list.isEmpty()) {
                list.forEach(System.out::println);
            } else {
                System.out.println("暂无数据");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbc.getClose();
        }

    }

    /**
     * 删除图书信息
     * <p>
     * 该方法通过数据库操作删除指定图书的信息。
     * 首先打印出删除图书信息的提示信息，然后创建一个TbBooks对象。
     * 接着，通过JDBC获取一个PreparedStatement对象，并设置SQL语句为"delete from tb_books where bok_id = ?"。
     * 提示用户输入图书编号，并将输入的编号设置到TbBooks对象中。
     * 尝试执行PreparedStatement对象的executeUpdate方法，删除指定的图书信息。
     * 如果删除成功，打印出删除成功的提示信息；如果删除失败，则捕获SQLException异常，并打印出删除失败的提示信息。
     * 最后，关闭数据库连接。
     */
    public void deleteBooks() {
        System.out.println("====== 删除图书信息 ======");
        TbBooks tbLibrary = new TbBooks();
        String sql = "delete from tb_books where bok_id = ?";

        PreparedStatement statument = jdbc.getStatument(sql);
        System.out.println("请输入图书编号:");
        tbLibrary.setBokId(scanner.nextInt());

        try {
            statument.setLong(1, tbLibrary.getBokId());
            int i = statument.executeUpdate();
            if (i > 0) {
                System.out.println("删除图书信息成功!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("删除图书信息失败!");
        } finally {
            jdbc.getClose();
        }
    }
}
