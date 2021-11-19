/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.java8.stream;

/**
 * 并行流与顺序流：
 * 1、并行流：就是把一个内容分成多个数据快，并用不同的线程分别处理每个数据块的流
 * java8中将并行进行了优化(1.7forkjoin框架)，我们可以很容易的对数据进行并行操作。StreamAPI可以声明性地通过parallel()与sequential()在并行流与顺序流直接进行切换
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-18 14:50
 * @since 1.2.0, 2019-05-18 14:50
 */
public class TestStreamAPI3 {
}
