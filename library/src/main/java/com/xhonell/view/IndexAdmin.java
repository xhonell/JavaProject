package com.xhonell.view;

import com.xhonell.dao.LibraryDao;
import com.xhonell.dao.LibraryTypeManger;
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
    public void menu(TbLibrarian tbLibrarian){
        while (true) {
            System.out.println("====== 菜单界面 ======");
            System.out.println("请选择您要进行的操作：\n\t1、图书馆信息管理\n\t" +
                    "2、图书分类管理\n\t3、图书馆信息管理\n\t4、学生信息管理\n\t5、借阅记录管理\n\t6、退出系统");
            System.out.print("请输入您的选择：");
            switch (scanner.nextInt()){
                case 1:
                    libraryManger();
                    break;
                case 2:
                    libraryTypeManger();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("输入错误，请重新输入！");
                    break;
            }
        }

    }

    private void libraryTypeManger() {
        while (true) {
            System.out.println("====== 图书分类管理 ======");
            System.out.println("请选择您要进行的操作：\n\t1、添加图书分类\n\t" +
                    "2、修改图书分类\n\t3、查询图书分类\n\t4、删除图书分类\n\t5、返回");
            LibraryTypeManger libraryTypeManger = new LibraryTypeManger();
            System.out.print("请输入您的选择：");
            switch (scanner.nextInt()){
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
