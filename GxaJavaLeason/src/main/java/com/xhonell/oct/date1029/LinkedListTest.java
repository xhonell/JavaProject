package com.xhonell.oct.date1029;

import com.xhonell.oct.date1018.HomeWork.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <p>Project:JavaProject - LinkedList
 * <p>POWER by xhonell on 2024-10-29 15:15
 * description：测试使用LinkListTest的方法
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class LinkedListTest {
    @Test
    public void linkedListTest() {
        LinkedList<Object> list = new LinkedList<>();

        list.add(1);
        list.add(new User());
        list.add("xhonell");
        list.add(2314.6);

        System.out.println(list.indexOf("xhonell"));

        System.out.println(list.remove(1));

        /*遍历输出*/
        Object[] array = list.toArray();
        System.out.println(Arrays.toString(array));


    }
}
