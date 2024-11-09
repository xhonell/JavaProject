package com.xhonell.dao;

import com.xhonell.entity.TbBorrow;
import com.xhonell.service.BorRetBook;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.xhonell.MainApp.jdbc;
import static com.xhonell.view.Index.scanner;

/**
 * <p>Project:JavaProject - BorrowRecordDao
 * <p>POWER by xhonell on 2024-11-09 10:26
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class BorrowRecordDao {
    /**
     * 添加借阅记录
     * <p>
     * 该方法用于向数据库中添加借阅记录。首先会提示用户输入借阅书籍编号和学生编号，
     * 然后调用数据库操作类jdbc获取PreparedStatement对象，并设置SQL语句。
     * 接着，通过调用BorRetBook类的borrowBook方法检查书籍是否可借。
     * 如果书籍可借，则执行SQL语句插入借阅记录；如果不可借或执行SQL语句失败，
     * 则打印相应的错误提示。
     */
    public void addBorrowRecord() {
        System.out.println("====== 添加借阅信息======");
        TbBorrow tbBorrow = new TbBorrow();
        String sql = "insert into tb_borrow(bok_id, stu_id) values(?,?)";
        PreparedStatement statument = jdbc.getStatument(sql);
        System.out.println("请输入借阅书籍编号:");
        tbBorrow.setBokId(scanner.nextLong());
        System.out.println("请输入借阅学生编号:");
        tbBorrow.setStuId(scanner.nextLong());

        if (!new BorRetBook().borrowBook(tbBorrow.getBokId())) {
            System.out.println("增加借阅信息失败!");
            return;
        }
        try {
            statument.setLong(1, tbBorrow.getBokId());
            statument.setLong(2, tbBorrow.getStuId());
            int i = statument.executeUpdate();
            if (i > 0) {
                System.out.println("增加借阅信息成功!");
            } else {
                System.out.println("增加借阅信息失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("增加借阅信息失败！");
        } finally {
            jdbc.getClose();
        }
    }

    /**
     * 更新借阅记录
     * <p>
     * 该方法用于更新借阅记录的归还时间。首先，从控制台获取借阅学生的ID和书籍的ID，
     * 然后检查该借阅记录是否存在。如果存在，则更新该记录的归还时间，并尝试归还书籍。
     * 如果书籍归还成功，则更新数据库中的借阅记录。如果更新失败，则打印错误信息。
     * 最后，关闭数据库连接。
     */
    public void updateBorrowRecord() {
        System.out.println("====== 修改借阅信息 ======");
        TbBorrow tbBorrow = new TbBorrow();
        String sql = "update tb_borrow set ret_time = ? where stu_id=? and bok_id=?";
        PreparedStatement statument = jdbc.getStatument(sql);
        System.out.println("请输入借阅学生ID:");
        tbBorrow.setStuId(scanner.nextLong());
        System.out.println("请输入借阅书籍ID:");
        tbBorrow.setBokId(scanner.nextLong());

        TbBorrow borrowRecord = getBorrowRecord(tbBorrow.getStuId(), tbBorrow.getBokId());
        if (null != borrowRecord) {
            borrowRecord.setRetTime(new Timestamp(System.currentTimeMillis()));
        } else {
            System.out.println("该借阅记录不存在!");
            return;
        }

        if (!new BorRetBook().returnBook(borrowRecord.getBokId())) {
            System.out.println("修改借阅信息失败!");
            return;
        }

        try {
            statument.setTimestamp(1, borrowRecord.getRetTime());
            statument.setLong(2, borrowRecord.getStuId());
            statument.setLong(3, borrowRecord.getBokId());
            int i = statument.executeUpdate();
            if (i > 0) {
                System.out.println("修改借阅信息成功!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("修改借阅信息失败!");
        } finally {
            jdbc.getClose();
        }
    }

    /**
     * 查询借阅信息
     * <p>
     * 查询数据库中所有借阅记录，并将查询结果打印出来
     */
    public void selectBorrowRecord() {
        System.out.println("====== 查询借阅信息 ======");
        List<TbBorrow> list = new ArrayList<>();
        String sql = "select stu_id, bok_id, bor_time, ret_time from tb_borrow";
        PreparedStatement statument = jdbc.getStatument(sql);
        try {
            ResultSet resultSet = statument.executeQuery();
            while (resultSet.next()) {
                TbBorrow tbBorrow = new TbBorrow();
                tbBorrow.setStuId(resultSet.getLong("stu_id"));
                tbBorrow.setBokId(resultSet.getLong("bok_id"));
                tbBorrow.setBorTime(resultSet.getTimestamp("bor_time"));
                tbBorrow.setRetTime(resultSet.getTimestamp("ret_time"));
                list.add(tbBorrow);
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
     * 删除借阅信息
     * <p>
     * 此方法用于删除数据库中特定学生和书籍的借阅记录。
     * 首先打印提示信息，然后提示用户输入借阅的学生编号和书籍编号，
     * 构造 SQL 语句并执行删除操作。如果删除成功，则打印成功信息；
     * 如果删除失败，则捕获异常并打印失败信息。
     */
    public void deleteBorrowRecord() {
        System.out.println("====== 删除借阅信息 ======");
        TbBorrow tbLibrary = new TbBorrow();
        String sql = "delete from tb_borrow where stu_id = ? and bok_id = ?";

        PreparedStatement statument = jdbc.getStatument(sql);
        System.out.println("请输入借阅学生编号:");
        tbLibrary.setStuId(scanner.nextLong());
        System.out.println("请输入借阅书籍编号:");
        tbLibrary.setBokId(scanner.nextLong());

        try {
            statument.setLong(1, tbLibrary.getStuId());
            statument.setLong(2, tbLibrary.getBokId());
            int i = statument.executeUpdate();
            if (i > 0) {
                System.out.println("删除借阅信息成功!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("删除借阅信息失败!");
        } finally {
            jdbc.getClose();
        }
    }

    /**
     * 根据学生ID和书本ID获取借阅记录
     *
     * @param stuId 学生ID
     * @param bokId 书本ID
     * @return 借阅记录对象，若不存在则返回null
     */
    public TbBorrow getBorrowRecord(Long stuId, Long bokId) {
        String sql = "select bok_id, stu_id,bor_time,ret_time from tb_borrow where stu_id = ? and bok_id = ?";
        PreparedStatement statument = jdbc.getStatument(sql);
        try {
            statument.setLong(1, stuId);
            statument.setLong(2, bokId);
            ResultSet resultSet = statument.executeQuery();

            if (resultSet.next()) {
                return new TbBorrow(
                        resultSet.getLong("bok_id"),
                        resultSet.getLong("stu_id"),
                        resultSet.getTimestamp("bor_time"),
                        resultSet.getTimestamp("ret_time")
                );
            } else return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
