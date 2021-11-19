/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.java8.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * java_20190508: MyAnnoation
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-19 15:08
 * @since 1.2.0, 2019-05-19 15:08
 */
@Repeatable(MyAnnoations.class)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnoation {

    String value() default "test";
}
