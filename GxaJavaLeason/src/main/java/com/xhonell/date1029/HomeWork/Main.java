package com.xhonell.date1029.HomeWork;

import org.junit.Test;

import java.util.*;

/**
 * <p>Project:JavaProject - Main
 * <p>POWER by xhonell on 2024-10-29 16:37
 * description：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class Main {

    /**
     * 测试类：测试作业第二题
     */
    @Test
    public void studentArrayListTest() {
        List<Object> list = new ArrayList<>();

        list.add(new Student("Tom", 18, 100, "class05"));
        list.add(new Student("Jerry", 22, 70, "class04"));
        list.add(new Student("Owen", 25, 90, "class05"));
        list.add(new Student("Jim", 30, 89, "class05"));
        list.add(new Student("Jim", 30, 80, "class05"));
        list.add(new Student("Steve", 28, 66, "class06"));
        list.add(new Student("Steve", 27, 67, "class06"));
        list.add(new Student("Steve", 29, 67, "class06"));
        list.add(new Student("Steve", 29, 67, "class04"));
        list.add(new Student("Kevin", 24, 100, "class04"));

        Set<Object> set = new HashSet<>(list);
        set.forEach(System.out::println);
    }

    /**
     * 测试类：测试工人第六题
     */
    @Test
    public void workArrayListTest() {
        List<Worker> list = new ArrayList<>();
        list.add(new Worker("张三", 18, 3000));
        list.add(new Worker("李四", 25, 3500));
        list.add(new Worker("王五", 22, 3200));

        /*在李四前面插入赵六的信息*/
        int index = 0;
        for (Object o : list) {
            if (o instanceof Worker) {
                if (((Worker) o).getName().equals("李四"))
                    index = list.indexOf(o);
            }
        }
        list.add(index, new Worker("赵六", 24, 3300));
        list.forEach(System.out::println);

        /*删除王五的信息*/
        for (Object o : list) {
            if (o instanceof Worker) {
                if (((Worker) o).getName().equals("王五"))
                    index = list.indexOf(o);
            }
        }
        list.remove(index);
        list.forEach(System.out::println);

        /*迭代器遍历集合*/
        Iterator<Worker> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
