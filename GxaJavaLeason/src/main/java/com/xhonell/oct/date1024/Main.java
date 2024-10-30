package com.xhonell.oct.date1024;

import org.junit.Test;

/**
 * <p>Project:JavaProject - Main
 * <p>POWER by xhonell on 2024-10-24 09:19
 * description：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class Main {

    /**
     * 测试类：测试NullPointerException类
     */
    @Test
    public void NullPointerExceptionTest() {
        NullPointerExceptionClass nullPointerExceptionClass = new NullPointerExceptionClass("xhonell", 18, 23.4);
        try {
            System.out.println(nullPointerExceptionClass);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } finally {
            nullPointerExceptionClass.setAge(19);
            System.out.println(nullPointerExceptionClass.getAge());
        }
    }

    /**
     * 测试类：测试Chat类
     * description：将敏感词替换为星号；
     */
    @Test
    public void chatTest() {

        StringBuffer stringBuffer = new StringBuffer("安倍是白痴,毒害奥巴马,枪杀特朗普,给拜登喂食冰毒，然后安倍进山进行躲避;\n" +
                "安倍是白痴，毒害奥巴马，枪杀特朗普，给拜登喂食冰毒，然后安倍晋三进行躲避；\n");

        Chat chat = new Chat();

        System.out.println(chat.replaceWord(stringBuffer));
    }

    /**
     * 测试类：测试FileIO类
     */
    @Test
    public void fileIoTest() {
        FileIO fileIO = new FileIO();
        fileIO.fileIO();

    }
}
