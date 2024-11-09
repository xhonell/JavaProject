package com.xhonell.dao;

import com.xhonell.entity.TbLibrary;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.xhonell.MainApp.jdbc;
import static com.xhonell.view.Index.scanner;

/**
 * <p>Project:JavaProject - library
 * <p>POWER by xhonell on 2024-11-08 16:04
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class LibraryDao {
    /**
     * 添加图书馆信息
     */
    public void addLibrary() {
        System.out.println("====== 添加图书管信息 ======");
        TbLibrary tbLibrary = new TbLibrary();
        String sql = "insert into tb_library(library_name, library_createTime, library_remark) values(?,?,?)";
        PreparedStatement statument = jdbc.getStatument(sql);
        System.out.println("请输入图书馆名称:");
        tbLibrary.setLibraryName(scanner.next());
        System.out.println("请输入图书馆备注:");
        tbLibrary.setLibraryRemark(scanner.next());
        try {
            statument.setString(1, tbLibrary.getLibraryName());
            statument.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            statument.setString(3, tbLibrary.getLibraryRemark());
            int i = statument.executeUpdate();
            if (i > 0) {
                System.out.println("增加图书馆信息成功!");
            } else {
                System.out.println("增加图书馆信息失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("增加图书馆信息失败！");
        } finally {
            jdbc.getClose();
        }
    }

    /**
     * 更新图书馆信息
     */
    public void updateLibrary() {
        System.out.println("====== 修改图书管信息 ======");
        TbLibrary tbLibrary = new TbLibrary();
        String sql = "update tb_library set library_name=?,library_remark=? where library_id=?";
        System.out.println("请输入图书馆ID:");
        tbLibrary.setLibraryId(scanner.nextInt());
        PreparedStatement statument = jdbc.getStatument(sql);
        System.out.println("请输入图书馆名称:");
        tbLibrary.setLibraryName(scanner.next());
        System.out.println("请输入图书馆备注:");
        tbLibrary.setLibraryRemark(scanner.next());

        try {
            statument.setString(1, tbLibrary.getLibraryName());
            statument.setString(2, tbLibrary.getLibraryRemark());
            statument.setLong(3, tbLibrary.getLibraryId());
            int i = statument.executeUpdate();
            if (i > 0) {
                System.out.println("修改图书馆信息成功!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("修改图书馆信息失败!");
        } finally {
            jdbc.getClose();
        }
    }

    /**
     * 查询图书馆信息
     * <p>
     * 该方法通过执行SQL查询语句，从数据库中检索图书馆信息，并将结果存储在列表中。
     * 如果查询成功，则遍历列表并打印每个图书馆的信息；如果列表为空，则输出“暂无数据”。
     * 如果在查询过程中发生SQL异常，则捕获异常并打印堆栈跟踪。
     */
    public void selectLibrary() {
        System.out.println("====== 查询图书管信息 ======");
        List<TbLibrary> list = new ArrayList<>();
        String sql = "select library_id, library_name, library_remark from tb_library";
        PreparedStatement statument = jdbc.getStatument(sql);
        try {
            ResultSet resultSet = statument.executeQuery();
            while (resultSet.next()) {
                TbLibrary tbLibrary = new TbLibrary();
                tbLibrary.setLibraryId(resultSet.getLong("library_id"));
                tbLibrary.setLibraryName(resultSet.getString("library_name"));
                tbLibrary.setLibraryRemark(resultSet.getString("library_remark"));
                list.add(tbLibrary);
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
}
