package com.xhonell.date1023.HomeWork;

/**
 * <p>Project:JavaProject - packClass
 * <p>POWER by xhonell on 2024-10-23 19:34
 * description：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class PackClass {
    public static void transition() {
        String str = "123";
        System.out.println(Integer.parseInt(str));
        System.out.println(Double.parseDouble(str));
        System.out.println(Long.parseLong(str));
        System.out.println(Float.parseFloat(str));
        System.out.println(Byte.parseByte(str));
        System.out.println(Short.parseShort(str));

        System.out.println(Integer.toString(4));
    }

    public static Integer toInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static String isBank(String str) {
        return str.trim().isEmpty() ? null : str.trim();
    }
}
