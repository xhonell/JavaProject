package com.xhonell.date1030;

import com.xhonell.date1029.HomeWork.Worker;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<Student> list = new ArrayList<>();

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

        /*Set<Object> set = new HashSet<>(list);
        set.forEach(System.out::println);

        list.sort((stu1, stu2) -> stu1.getAge() > stu2.getAge() ? -1 : 1);
        list.forEach(System.out::println);

        List<Student> studentList = list.stream().filter(n -> n.getSalary() > 70)
                                        .collect(Collectors.toList());


        studentList.sort((stu1, stu2) -> {
            if (Objects.equals(stu1.getSalary(), stu2.getSalary())) {
                if (Objects.equals(stu1.getAge(), stu2.getAge())) {
                    return stu1.getLessonName().hashCode() > stu2.getLessonName().hashCode() ? -1 : 1;
                }else{
                    return stu1.getAge() > stu2.getAge() ? -1 : 1;
                }
            }else {
                return stu1.getSalary() > stu2.getSalary() ? -1 : 1;
            }
        });
        System.out.println("==============================");
        studentList.forEach(System.out::println);*/

        /*List<Student> studentList = list.stream()
                .filter(n -> n.getSalary() >= 70)
                .sorted(Comparator.comparingDouble(Student::getSalary)
                        .thenComparingInt(Student::getAge)
                        .thenComparing(Student::getLessonName))
                .collect(Collectors.toList());

        studentList.forEach(System.out::println);*/

        numberLesson(list);
    }

    public void numberLesson(List<Student> list) {
        Map lessonMap = new HashMap();
        for (Student student : list) {
            lessonMap.put(student.getLessonName(), 0);
        }
        for (Student student : list) {
            if (lessonMap.containsKey(student.getLessonName())) {
                lessonMap.replace(student.getLessonName(), (Integer) lessonMap.get(student.getLessonName()) + 1);
            }
        }

        lessonMap.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });

    }

}
