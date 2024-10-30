package com.xhonell.oct.date1024.HomeWork;

import java.util.Arrays;

/**
 * <p>Project:JavaProject - FiltrationWord
 * <p>POWER by xhonell on 2024-10-24 16:49
 * description：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class FiltrationWord {

    private static String[] sensitiveWords = {"白痴", "笨", "冰毒", "死", "杀", "奥巴马", "特朗普", "安倍晋三"};

    public static String fileWord(String word) {
        StringBuffer sb = new StringBuffer(word);
        for (String sensitiveWord : sensitiveWords) {
            int start = sb.indexOf(sensitiveWord);

            char[] xh = new char[sensitiveWord.length()];

            if (sensitiveWord.length() >= 3) xh = new char[3];
            Arrays.fill(xh, '*');
            String strXh = new String(xh);
            while (start != -1) {
                sb.replace(start, start + sensitiveWord.length(), strXh);
                start = sb.indexOf(sensitiveWord, start + sensitiveWord.length());
            }

        }
        return sb.toString();
    }
}
