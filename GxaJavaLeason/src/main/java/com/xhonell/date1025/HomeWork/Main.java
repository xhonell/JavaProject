package com.xhonell.date1025.HomeWork;

import com.xhonell.date1025.FileTools;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;

import static com.xhonell.date1025.DataFileStream.PATH;

/**
 * <p>Project:JavaProject - Main
 * <p>POWER by xhonell on 2024-10-26 09:19
 * description：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class Main {
    /**
     * 主函数：用于测试登录和注册方法
     *
     * @param args
     */
    public static void main(String[] args) {
        LoginRegister loginRegister = new LoginRegister();
        loginRegister.menu();
    }

    /**
     * 测试类：测试exchangeFileTest类，文件能否正常交换
     *
     * @throws IOException
     */
    @Test
    public void exchangeFileTest() throws IOException {
        String src = "F:\\Users\\xhonell\\AppData\\Roaming\\feiq\\Recv Files\\课堂笔记(1).txt";
        String path = "F:\\Users\\xhonell\\Documents\\Projects\\IdeaProjects\\JavaProject\\GxaJavaLeason\\src\\main\\java\\com\\xhonell\\date1025\\HomeWork\\hello.text";
//      /*temp.txt 可以用File创建，使用结束后自动给删除*/
        String temp = "F:\\Users\\xhonell\\Documents\\Projects\\IdeaProjects\\JavaProject\\GxaJavaLeason\\src\\main\\java\\com\\xhonell\\date1025\\HomeWork\\temp.txt";
        ExchangeFile exchangeFile = new ExchangeFile();

        String fileSrc = exchangeFile.readFile(src);//源文件
        exchangeFile.writeFile(temp, fileSrc);

        String filePath = exchangeFile.readFile(path);//目标文件
        exchangeFile.writeFile(src, filePath);

        String fileTemp = exchangeFile.readFile(temp);
        exchangeFile.writeFile(path, fileTemp);
    }

    @Test
    public void workOneTest() throws IOException {
        String src = "F:\\Users\\xhonell\\AppData\\Roaming\\feiq\\Recv Files\\课堂笔记(1).txt";
        String path = "F:\\Users\\xhonell\\AppData\\Roaming\\feiq\\Recv Files";

        String fileName = FileTools.getFileName(src);
        String suffix = FileTools.getSuffix(src);

        ExchangeFile exchangeFile = new ExchangeFile();
        String file = exchangeFile.readFile(src);
        path = path + "\\" + fileName + LocalDate.now() + suffix;
        exchangeFile.writeFile(path, file);
    }
}
