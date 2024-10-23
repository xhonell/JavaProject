package com.xhonell.date1023.HomeWork;

import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

/**
 * <p>Project:JavaProject - Main
 * <p>POWER by xhonell on 2024-10-23 17:00
 * description:
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class Main {
    /**
     * 测试类：测试FormatTool工具类
     *
     * @throws ParseException
     */
    @Test
    public void formatToolTest() throws ParseException {
        System.out.println(FormatTool.dateToLocaldate(new Date()));
        System.out.println(FormatTool.localDateToDate(LocalDate.now()));
        System.out.println(FormatTool.stringToLocalDate("20191023", "yyyyMMdd"));
        System.out.println(FormatTool.stringToDate("20191023", "yyyyMMdd"));
        System.out.println(FormatTool.dateToString(new Date(), "yyyy-MM-dd"));
        System.out.println(FormatTool.localDateToString(LocalDate.now(), "yyyy-MM-dd"));
        System.out.println(FormatTool.stringtoLocalDate("20191023", "yyyyMMdd"));
    }
}
