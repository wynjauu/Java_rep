/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.java8.day01;

import java.util.*;

/**
 * java_20190508: TestLambda
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-13 23:46
 * @since 1.2.0, 2019-05-13 23:46
 */
public class TestLambda {
    public static void main(String[] args) {
        TreeSet<Integer> ots = new TreeSet<>();
        ots.add(3);
        ots.add(2);
        ots.add(5);
        ots.add(1);
        System.out.println(ots);

//        Comparator<Integer> comparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o2, o1);
//            }
//        };
//        TreeSet<Integer> ts = new TreeSet<>(comparator);
//        ts.add(3);
//        ts.add(2);
//        ts.add(5);
//        ts.add(1);
//        System.out.println(ts);

        Comparator<Integer> com = (x, y) -> Integer.compare(y, x);
        TreeSet<Integer> ts = new TreeSet<>(com);
        ts.add(3);
        ts.add(2);
        ts.add(5);
        ts.add(1);
        System.out.println(ts);
    }

    //原来的匿名内部类
    public static void test() {
        TreeSet<Integer> ots = new TreeSet<>();
        ots.add(3);
        ots.add(2);
        ots.add(5);
        ots.add(1);
        System.out.println(ots);
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);
        ts.add(3);
        ts.add(2);
        ts.add(5);
        ts.add(1);
        System.out.println(ts);
    }

    //Lambada 表达式
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 9999.99),
            new Employee("王五", 59, 9999.99),
            new Employee("赵六", 20, 33333),
            new Employee("田七", 18, 111)
    );

    //需求：获取当前公司中员工年龄大于30的员工信息
    public void testE() {
        List<Employee> list = filterEmpployees(employees);
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    public List<Employee> filterEmpployees(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (emp.getAge() >= 30) {
                emps.add(emp);
            }
        }
        return emps;
    }

    //需求改了，工资大于3000的
    public List<Employee> filterEmpployees2(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (emp.getSalary() < 5000) {
                emps.add(emp);
            }
        }
        return emps;
    }

    //=============优化方式一:设计模式的策略模式
    public void test4() {
        List<Employee> list = filterEmployee(employees, new FilterEmployeeByAge());
        for (Employee employee : list) {
            System.out.println(employee);
        }

        List<Employee> list2 = filterEmployee(employees, new FilterEmployeeBySalary());
        for (Employee employee : list2) {
            System.out.println(employee);
        }
    }

    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if (mp.test(employee)) {
                emps.add(employee);
            }
        }
        return emps;
    }

    //=============优化方式二：匿名内部类
    public void test5() {
        List<Employee> list = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() < 5000;
            }
        });
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    //=============优化方式三：Lambda表达式
    public void test6() {
        List<Employee> list = filterEmployee(employees, (e) -> e.getSalary() < 5000);
        list.forEach(System.out::println);
    }

    //=============优化方式四：Stream API
    public void test7() {
        employees.stream()
                .filter((e) -> e.getSalary() < 5000)
                .forEach(System.out::println);

    }

}
