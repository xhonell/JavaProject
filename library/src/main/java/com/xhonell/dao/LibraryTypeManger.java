package com.xhonell.dao;

import com.xhonell.entity.TbClassify;
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
 * <p>Project:JavaProject - LibraryTypeManger
 * <p>POWER by xhonell on 2024-11-08 17:53
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class LibraryTypeManger {
    /**
     * 添加图书类型
     * <p>
     * 该方法用于向数据库中添加新的图书类型
     */
    public void addLibraryType() {
        System.out.println("====== 添加图书类型 ======");
        TbClassify tbLibrary = new TbClassify();
        String sql = "insert into tb_classify(cla_name) values(?)";
        PreparedStatement statument = jdbc.getStatument(sql);
        System.out.println("请输入添加类型的名称:");
        tbLibrary.setClaName(scanner.next());
        try {
            statument.setString(1, tbLibrary.getClaName());
            int i = statument.executeUpdate();
            if (i > 0) {
                System.out.println("增加图书类型成功!");
            } else {
                System.out.println("增加图书类型失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("增加图书馆信息失败！");
        } finally {
            jdbc.getClose();
        }
    }

    /**
     * 更新图书类型的方法
     */
    public void updateLibraryType() {
        System.out.println("====== 修改图书类型 ======");
        TbClassify tbLibrary = new TbClassify();
        String sql = "update tb_classify set cla_name=?";

        PreparedStatement statument = jdbc.getStatument(sql);
        System.out.println("请输入图书类型名称:");
        tbLibrary.setClaName(scanner.next());

        try {
            statument.setString(1, tbLibrary.getClaName());
            int i = statument.executeUpdate();
            if (i > 0) {
                System.out.println("修改图书类型成功!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("修改图书类型失败!");
        } finally {
            jdbc.getClose();
        }
    }

    /**
     * 查询图书类型
     */
    public void selectLibraryType() {
        System.out.println("====== 查询图书类型 ======");
        List<TbClassify> list = new ArrayList<>();
        String sql = "select cla_id, cla_name  from tb_classify";
        PreparedStatement statument = jdbc.getStatument(sql);
        try {
            ResultSet resultSet = statument.executeQuery();
            while (resultSet.next()) {
                TbClassify tbLibrary = new TbClassify();
                tbLibrary.setClaId(resultSet.getLong("cla_id"));
                tbLibrary.setClaName(resultSet.getString("cla_name"));
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

    /**
     * 删除图书类型
     */
    public void deleteLibraryType() {
        System.out.println("====== 删除图书类型 ======");
        TbClassify tbLibrary = new TbClassify();
        String sql = "delete from tb_classify where cla_id = ?";

        PreparedStatement statument = jdbc.getStatument(sql);
        System.out.println("请输入图书类型编号:");
        tbLibrary.setClaId(scanner.nextInt());

        try {
            statument.setLong(1, tbLibrary.getClaId());
            int i = statument.executeUpdate();
            if (i > 0) {
                System.out.println("删除图书类型成功!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("删除图书类型失败!");
        } finally {
            jdbc.getClose();
        }
    }
}
