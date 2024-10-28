package com.xhonell.date1025;

import com.xhonell.date1025.HomeWork.LoginRegister;
import com.xhonell.date1025.HomeWork.User;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * <p>Project:JavaProject - Main
 * <p>POWER by xhonell on 2024-10-25 10:31
 * description：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class Main {

    @Test
    public void copyPictureTest() throws IOException {
        String src = "F:\\Users\\xhonell\\Documents\\论文\\开题报告.docx";
        String path = "F:\\Users\\xhonell\\Pictures";
        System.out.println(FileTools.getFullFileName(src) + (CopyPicture.copyPicture(src, path) ? " 拷贝成功" : " 拷贝失败"));
    }

    @Test
    public void BufferedFileTest() throws IOException {
        BufferedFile bufferedFile = new BufferedFile();
        bufferedFile.bufferedFileRead();
    }

    @Test
    public void dataFileStreamTest() throws IOException, ClassNotFoundException {
        DataFileStream dataFileStream = new DataFileStream();
        dataFileStream.saveDataOutputStream(new User("黄雄", "123123"));
        dataFileStream.saveDataOutputStream(new User("xhonell", "123123"));

        System.out.println(Arrays.toString(dataFileStream.readDataInputStream()));
    }

    public static void main(String[] args) {
        LoginRegister loginRegister = new LoginRegister();
        loginRegister.menu();
    }

}
