package com.xhonell.date1030.HomeWork;

import org.junit.Test;

import java.util.*;

/**
 * <p>Project:JavaProject - Main
 * <p>POWER by xhonell on 2024-10-30 22:38
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class Main {
    @Test
    public void listStudentTest() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Tom ", 18, 100.0, "class05 "));
        list.add(new Student("Jerry ", 22, 70.0, "class04 "));
        list.add(new Student("Owen ", 25, 90.0, "class05 "));
        list.add(new Student("Jim ", 30, 80.0, "class05 "));
        list.add(new Student("Steve ", 28, 66.0, "class06 "));
        list.add(new Student("Kevin ", 24, 100.0, "class04 "));

        System.out.println("学生平均成绩：" + getAverageByStudent(list));

        getAverageByClass(list).forEach((v, k) -> {
            System.out.println("班级：" + v + ": " + "平均成绩：" + k);
        });
    }

    /**
     * 计算集合中的平均成绩
     *
     * @param list
     * @return
     */
    public Double getAverageByStudent(List<Student> list) {
        Double average = 0.0;
        for (Student student : list) {
            average += student.getSalary();
        }
        return average / list.size();

    }

    /**
     * 计算每个班的平均成绩
     *
     * @param list
     * @return
     */
    public Map getAverageByClass(List<Student> list) {
        Map map = new HashMap();
        Map mapNum = new HashMap();
        Map mapAvg = new HashMap();
        /*创建班级总成绩表*/
        list.forEach(student -> {
            map.put(student.getClassNum(), 0.0);
            mapNum.put(student.getClassNum(), 0.0);
        });
        /*为班级总成绩付初始值*/
        list.forEach((student) -> {
            if (map.containsKey(student.getClassNum())) {
                map.replace(student.getClassNum(), (Double) map.get(student.getClassNum()) + student.getSalary());
                mapNum.replace(student.getClassNum(), (Double) mapNum.get(student.getClassNum()) + 1);
            }
        });
        /*计算班级平均成绩*/
        map.forEach((k, v) -> {
            mapAvg.put(k, (Double) v / (Double) (mapNum.get(k)));
        });

        return mapAvg;
    }
}
