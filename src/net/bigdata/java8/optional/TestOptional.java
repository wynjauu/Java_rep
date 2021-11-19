/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.java8.optional;

import net.bigdata.java8.day01.Employee;

import java.util.Optional;

/**
 * java_20190508: TestOptional
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-18 15:31
 * @since 1.2.0, 2019-05-18 15:31
 */
public class TestOptional {
    /*
        Optional.of(T t) :  创建一个Optional实例
        Optional.empty() :  创建一个空的Optional实例
        Optional.ofNullable(T t) : 若t不为null，创建Optional实例，否则创建空实例
        isPresent() : 判断是否包含值
        orElse(T t) : 如果调用对象包含值，返回该值，否则返回t
        orElseGet(Supplier s) : 如果调用对象包含值，返回该值，否则返回 s 获取的值
        map(Function f) : 如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty()
        flatMap(Function mapper) : 与map类似，要求返回值必须是Optional
     */

    public void test() {
        Optional<Employee> op = Optional.of(new Employee());
        Employee em = op.get();
        System.out.println(em);


        //
        Optional<Employee> op1 = Optional.of(null);//空指针
        Employee employee = op1.get();
        System.out.println(employee);


        //
        Optional<Employee> op3 = Optional.empty();
        System.out.println(op3.get());

        //
        Optional<Employee> op4 = Optional.ofNullable(null);
        System.out.println(op4.get());//空指针
        if (op4.isPresent()) {
            op4.get();
        }


        Employee op5 = op4.orElse(new Employee("zhang", 11, 1D, Employee.Status.BUSY));
        op4.orElseGet(() -> new Employee("zhang", 11, 1D, Employee.Status.BUSY));
        Optional<Integer> integer = op4.map((e) -> e.getAge());
        System.out.println(integer.get());

        Optional<String> optionalS = op.flatMap((e) -> Optional.of(e.getName()));
        System.out.println(optionalS.get());
    }

    public void test2() {
        Man man = new Man();
        String n = getGodnessName(man);
    }

    public String getGodnessName(Man man) {
        //return man.getGodness().getName(); //空指针
        if (man != null) {
            Godness godness = man.getGodness();
            if (godness != null) {
                return godness.getName();
            }
        }
        return "仓老师";
    }

    public void test3() {
        Optional<NewMan> op = Optional.ofNullable(new NewMan());
        Optional<Godness> gd = Optional.ofNullable(new Godness());

        getGodnessName2(op);
    }


    public String getGodnessName2(Optional<NewMan> newMan) {
        return newMan
                .orElse(new NewMan())
                .getGodness()
                .orElse(new Godness("仓老师"))
                .getName();
    }

}
