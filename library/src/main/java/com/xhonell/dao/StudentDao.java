package com.xhonell.dao;

import com.xhonell.entity.TbStudent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.xhonell.MainApp.jdbc;
import static com.xhonell.view.Index.scanner;

/**
 * <p>Project:JavaProject - StudentDao
 * <p>POWER by xhonell on 2024-11-09 09:53
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class StudentDao {
    /**
     * 添加学生信息
     * <p>
     * 该方法通过JDBC连接数据库，并插入一条新的学生信息到数据库表中。
     *
     * @throws SQLException 如果数据库操作出现错误，将抛出SQLException异常
     */
    public void addStudent() {
        System.out.println("====== 添加学生信息======");
        TbStudent tbStudent = new TbStudent();
        String sql = "insert into tb_student(stu_name, stu_age, stu_sex) values(?,?,?)";
        PreparedStatement statument = jdbc.getStatument(sql);
        System.out.println("请输入学生名称:");
        tbStudent.setStuName(scanner.next());
        System.out.println("请输入学生年龄:");
        tbStudent.setStuAge(scanner.nextInt());
        System.out.println("请输入学生性别:");
        tbStudent.setStuSex(scanner.next());
        try {
            statument.setString(1, tbStudent.getStuName());
            statument.setLong(2, tbStudent.getStuAge());
            statument.setString(3, tbStudent.getStuSex());
            int i = statument.executeUpdate();
            if (i > 0) {
                System.out.println("增加学生信息成功!");
            } else {
                System.out.println("增加学生信息失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("增加学生信息失败！");
        } finally {
            jdbc.getClose();
        }
    }

    /**
     * 更新学生信息
     */
    public void updateStudent() {
        System.out.println("====== 修改学生信息 ======");
        TbStudent tbStudent = new TbStudent();
        String sql = "update tb_student set stu_name=?,stu_sex=?,stu_age = ? where stu_id=?";
        System.out.println("请输入学生ID:");
        tbStudent.setStuId(scanner.nextInt());
        PreparedStatement statument = jdbc.getStatument(sql);
        System.out.println("请输入学生名称:");
        tbStudent.setStuName(scanner.next());
        System.out.println("请输入学生年龄:");
        tbStudent.setStuAge(scanner.nextInt());
        System.out.println("请输入学生性别:");
        tbStudent.setStuSex(scanner.next());

        try {
            statument.setString(1, tbStudent.getStuName());
            statument.setString(2, tbStudent.getStuSex());
            statument.setLong(3, tbStudent.getStuAge());
            statument.setLong(4, tbStudent.getStuId());
            int i = statument.executeUpdate();
            if (i > 0) {
                System.out.println("修改学生信息成功!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("修改学生信息失败!");
        } finally {
            jdbc.getClose();
        }
    }

    /**
     * 查询学生信息
     */
    public void selectStudent() {
        System.out.println("====== 查询学生信息 ======");
        List<TbStudent> list = new ArrayList<>();
        String sql = "select stu_id, stu_name, stu_sex, stu_age from tb_student";
        PreparedStatement statument = jdbc.getStatument(sql);
        try {
            ResultSet resultSet = statument.executeQuery();
            while (resultSet.next()) {
                TbStudent tbStudent = new TbStudent();
                tbStudent.setStuId(resultSet.getLong("stu_id"));
                tbStudent.setStuName(resultSet.getString("stu_name"));
                tbStudent.setStuSex(resultSet.getString("stu_sex"));
                tbStudent.setStuAge(resultSet.getLong("stu_age"));
                list.add(tbStudent);
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
     * 删除学生信息
     */
    public void deleteStudent() {
        System.out.println("====== 删除学生信息 ======");
        TbStudent tbLibrary = new TbStudent();
        String sql = "delete from tb_student where stu_id = ?";

        PreparedStatement statument = jdbc.getStatument(sql);
        System.out.println("请输入学生编号:");
        tbLibrary.setStuId(scanner.nextInt());

        try {
            statument.setLong(1, tbLibrary.getStuId());
            int i = statument.executeUpdate();
            if (i > 0) {
                System.out.println("删除学生信息成功!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("删除学生信息失败!");
        } finally {
            jdbc.getClose();
        }
    }
}
