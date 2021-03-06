/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.java8.day01;

/**
 * java_20190508: FilterEmployeeBySalary
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-14 00:16
 * @since 1.2.0, 2019-05-14 00:16
 */
public class FilterEmployeeBySalary implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() < 5000;
    }
}
