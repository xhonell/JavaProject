package com.xhonell.oct.date1024;

import java.util.Arrays;

/**
 * <p>Project:JavaProject - Chat
 * <p>POWER by xhonell on 2024-10-24 15:16
 * description：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class Chat {
    private static String[] forbid = {"白痴", "笨", "冰毒", "死", "杀", "奥巴马", "特朗普", "安倍晋三"};


    String strOne = "*";
    String strTwo = "**";
    String strThree = "***";


    public StringBuffer replaceWord(StringBuffer sb) {
        for (String s : forbid) {
            int start = sb.indexOf(s);
            int wordLength = s.length();
            char[] numForSymbol = new char[wordLength];
            if (wordLength >= 3) {
                numForSymbol = new char[3];
            }
            Arrays.fill(numForSymbol, '*');
            String wordReplace = new String(numForSymbol);
            while (start != -1) {
                sb.replace(start, start + wordLength, wordReplace);

                start = sb.indexOf(s, start + wordLength);
            }
        }
        return sb;
    }
}
