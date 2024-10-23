package com.xhonell.date1023.HomeWork;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * <p>Project:JavaProject - FormatTool
 * <p>POWER by xhonell on 2024-10-23 17:01
 * description：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class FormatTool {
    public static LocalDate dateToLocaldate(Date date) {
        if (date != null) {
            String dateString = dateToString(date, "yyyyMMdd");
            return stringToLocalDate(dateString, "yyyyMMdd");
        } else return null;
    }

    public static Date localDateToDate(LocalDate date) throws ParseException {
        if (date != null) {
            String dateString = localDateToString(date, "yyyyMMdd");
            return stringToDate(dateString, "yyyyMMdd");
        }
        return null;
    }

    public static LocalDate stringToLocalDate(String dateString, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(dateString, formatter);
    }

    public static Date stringToDate(String dateString, String pattern) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.parse(dateString);
    }

    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    public static LocalDate stringtoLocalDate(String dateString, String pattern) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(pattern));
    }


    public static String localDateToString(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}
