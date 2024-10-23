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
public class packClass {
    public void transition() {
        String str = "123";
        System.out.println(Integer.parseInt(str));
        System.out.println(Double.parseDouble(str));
        System.out.println(Long.parseLong(str));
        System.out.println(Float.parseFloat(str));
        System.out.println(Byte.parseByte(str));
        System.out.println(Short.parseShort(str));

        System.out.println(Integer.toString(4));
    }

    public String getString(String str) {
        if (!str.matches("-?\\\\d+(\\\\.\\\\d+)?")) {
            return "不是数字";
        }
        int a = Integer.parseInt(str);
        System.out.println(a);
        double b = Double.parseDouble(str);
        System.out.println(b);

        if (str.trim().isEmpty()) {
            return null;
        }

        return str;

    }
}
