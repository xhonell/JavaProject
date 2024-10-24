package com.xhonell.date1024.HomeWork;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * <p>Project:JavaProject - Main
 * <p>POWER by xhonell on 2024-10-24 16:49
 * description：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class Main {

    @Test
    public void filtrationWordTest() {
        String chatString = "安倍是白痴，毒害奥巴马，枪杀特朗普，给拜登喂食冰毒，然后安倍晋三进行躲避";
        System.out.println(FiltrationWord.fileWord(chatString));
    }

    @Test
    public void traverseDirectoryTest() throws FileNotFoundException {
        String path = "F:\\Users\\xhonell\\Pictures";
        File file = new File(path);
        TraverseDirectory.traverseDirectory(file);
    }
}
