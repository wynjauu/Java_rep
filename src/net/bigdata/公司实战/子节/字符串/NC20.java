/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.字符串;

import java.util.ArrayList;

/**
 * Java_rep: NC20 数字字符串转化成IP地址
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-14 17:19
 * @since 1.2.0, 2021-12-14 17:19
 */
public class NC20 {

    ArrayList<String> list = new ArrayList<>();

    public ArrayList<String> stringToIp(String s) {
        ArrayList<String> path = new ArrayList<>();
        h(s, 0, path);
        return list;
    }

    public void h(String str, int startIndex, ArrayList<String> path) {
        if (path.size() == 4) {
            String fi = path.get(0);
            String se = path.get(1);
            String th = path.get(2);
            String fo = path.get(3);
            if (fi.length() + se.length() + th.length() + fo.length() == str.length()) {
                list.add(fi + "." + se + "." + th + "." + fo);
            }
            return;
        }

        for (int i = startIndex; i < str.length() && i < startIndex + 3; i++) {
            String s = str.substring(startIndex, i + 1);
            Integer num = Integer.parseInt(s);
            if (0 <= num && num <= 255) {
                path.add(num.toString()); //特别注意这边不能直接写：path.add(s); 不然："010010" 会有 "0.1.00.10、0.10.01.0之类的出现
                h(str, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
