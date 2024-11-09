package com.xhonell.view;

import com.xhonell.dao.*;
import com.xhonell.entity.TbLibrarian;

import static com.xhonell.view.Index.scanner;

/**
 * <p>Project:JavaProject - IndexAdmin
 * <p>POWER by xhonell on 2024-11-08 15:38
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class IndexAdmin {
    /**
     * 显示并处理图书馆管理系统菜单
     *
     * @param tbLibrarian 图书馆管理员实体对象
     */
    public void menu(TbLibrarian tbLibrarian) {
        while (true) {
            System.out.println("====== 菜单界面 ======");
            System.out.println("请选择您要进行的操作：\n\t1、图书馆信息管理\n\t" +
                    "2、图书分类管理\n\t3、图书信息管理\n\t4、学生信息管理\n\t5、借阅记录管理\n\t6、退出系统");
            System.out.print("请输入您的选择：");
            switch (scanner.nextInt()) {
                case 1:
                    libraryManger();
                    break;
                case 2:
                    libraryTypeManger();
                    break;
                case 3:
                    libraryBookManger();
                    break;
                case 4:
                    studentManger();
                    break;
                case 5:
                    borrowRecordManger();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("输入错误，请重新输入！");
                    break;
            }
        }

    }

    /**
     * 管理借阅信息的方法
     */
    private void borrowRecordManger() {
        while (true) {
            System.out.println("====== 借阅信息管理 ======");
            System.out.println("请选择您要进行的操作：\n\t1、添加借阅信息\n\t" +
                    "2、修改借阅信息\n\t3、查询借阅信息\n\t4、删除借阅信息\n\t5、返回");
            BorrowRecordDao borrowRecordDao = new BorrowRecordDao();
            System.out.print("请输入您的选择：");
            switch (scanner.nextInt()) {
                case 1:
                    borrowRecordDao.addBorrowRecord();
                    break;
                case 2:
                    borrowRecordDao.updateBorrowRecord();
                    break;
                case 3:
                    borrowRecordDao.selectBorrowRecord();
                    break;
                case 4:
                    borrowRecordDao.deleteBorrowRecord();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("输入错误，请重新输入！");
                    break;
            }
        }
    }

    /**
     * 学生信息管理方法
     * <p>
     * 此方法提供一个无限循环，用户可以通过输入不同的选项来执行不同的学生信息管理操作。
     * 包括添加学生信息、修改学生信息、查询学生信息、删除学生信息以及返回操作。
     *
     * @return 无返回值
     */
    private void studentManger() {
        while (true) {
            System.out.println("====== 学生信息管理 ======");
            System.out.println("请选择您要进行的操作：\n\t1、添加学生信息\n\t" +
                    "2、修改学生信息\n\t3、查询学生信息\n\t4、删除学生信息\n\t5、返回");
            StudentDao studentDao = new StudentDao();
            System.out.print("请输入您的选择：");
            switch (scanner.nextInt()) {
                case 1:
                    studentDao.addStudent();
                    break;
                case 2:
                    studentDao.updateStudent();
                    break;
                case 3:
                    studentDao.selectStudent();
                    break;
                case 4:
                    studentDao.deleteStudent();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("输入错误，请重新输入！");
                    break;
            }
        }
    }

    /**
     * 图书分类管理功能实现
     * <p>
     * 该方法提供了一个循环菜单，用户可以通过选择不同的选项来执行添加、修改、查询、删除图书信息和返回操作。
     * 使用LibraryBooksDao类来执行具体的数据库操作。
     */
    private void libraryBookManger() {
        while (true) {
            System.out.println("====== 图书分类管理 ======");
            System.out.println("请选择您要进行的操作：\n\t1、添加图书信息\n\t" +
                    "2、修改图书信息\n\t3、查询图书信息\n\t4、删除图书信息\n\t5、返回");
            LibraryBooksDao tbBooks = new LibraryBooksDao();
            System.out.print("请输入您的选择：");
            switch (scanner.nextInt()) {
                case 1:
                    tbBooks.addBooks();
                    break;
                case 2:
                    tbBooks.updateBooks();
                    break;
                case 3:
                    tbBooks.selectBooks();
                    break;
                case 4:
                    tbBooks.deleteBooks();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("输入错误，请重新输入！");
                    break;
            }
        }
    }

    /**
     * 图书分类管理功能
     */
    private void libraryTypeManger() {
        while (true) {
            System.out.println("====== 图书分类管理 ======");
            System.out.println("请选择您要进行的操作：\n\t1、添加图书分类\n\t" +
                    "2、修改图书分类\n\t3、查询图书分类\n\t4、删除图书分类\n\t5、返回");
            LibraryTypeManger libraryTypeManger = new LibraryTypeManger();
            System.out.print("请输入您的选择：");
            switch (scanner.nextInt()) {
                case 1:
                    libraryTypeManger.addLibraryType();
                    break;
                case 2:
                    libraryTypeManger.updateLibraryType();
                    break;
                case 3:
                    libraryTypeManger.selectLibraryType();
                    break;
                case 4:
                    libraryTypeManger.deleteLibraryType();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("输入错误，请重新输入！");
                    break;
            }
        }
    }

    /**
     * 图书馆信息管理方法
     *
     * 此方法用于管理图书馆信息，包括添加、查询、修改和返回等操作。
     */
    private void libraryManger() {
        while (true) {
            System.out.println("====== 图书馆信息管理 ======");
            System.out.println("请选择您要进行的操作：\n\t1、添加图书馆信息\n\t2、查询图书馆信息\n\t3、修改图书馆信息\n\t4、返回");
            LibraryDao libraryDao = new LibraryDao();
            System.out.print("请输入您的选择：");
            switch (scanner.nextInt()) {
                case 1:
                    libraryDao.addLibrary();
                    break;
                case 2:
                    libraryDao.selectLibrary();
                    break;
                case 3:
                    libraryDao.updateLibrary();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("输入错误，请重新输入！");
                    break;
            }
        }
    }
}
