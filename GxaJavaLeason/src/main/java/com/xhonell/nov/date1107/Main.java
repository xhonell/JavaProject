package com.xhonell.nov.date1107;

import com.xhonell.oct.date1015.RegisterLogin;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * <p>Project:JavaProject - Main
 * <p>POWER by xhonell on 2024-11-07 11:06
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Class containerClass = RegisterLogin.class;

        Annotation[] declaredAnnotations = containerClass.getDeclaredAnnotations();

        System.out.println(Arrays.toString(declaredAnnotations));

        Field[] declaredField = containerClass.getDeclaredFields();

        System.out.println(Arrays.toString(declaredField));

        Method[] declaredMethods = containerClass.getDeclaredMethods();

        System.out.println(Arrays.toString(declaredMethods));

//        Method method = containerClass.getMethod("main");

        Field count = containerClass.getDeclaredField("count");

    }
}
