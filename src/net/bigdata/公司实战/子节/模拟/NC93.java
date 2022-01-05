/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.模拟;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Java_rep: NC93
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-20 13:59
 * @since 1.2.0, 2021-12-20 13:59
 */
public class NC93 {
    public class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    public class DoubleList {
        Node head;
        Node tail;
        int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            size = 0;
            head.next = tail;
            tail.prev = head;
        }

        //尾部插入last，保持尾部是最近使用的
        public void insertTail(Node node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }

        //头部first删除
        public void removeHead() {
            if (head.next == tail) {
                return;
            }
            Node node = head.next;
            head.next = node.next;
            node.next.prev = head;
            size--;
        }

        public void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public int getSize() {
            return size;
        }
    }


    public class LRUCache {
        private HashMap<Integer, Node> map;
        private DoubleList doubleList;
        private int capacity;

        public LRUCache(int size) {
            map = new HashMap<>();
            doubleList = new DoubleList();
            this.capacity = size;
        }

        private void replace(int k, int v) {
            Node node = map.get(k);
            doubleList.removeNode(node);
            Node node1 = new Node(k, v);
            doubleList.insertTail(node1);
            map.put(k, node1);
        }

        private void add(int k, int v) {
            Node node = new Node(k, v);
            if (doubleList.getSize() == capacity) {
                doubleList.removeHead();
            }
            doubleList.insertTail(node);
            map.put(k, node);
        }

        private Node getByK(int k) {
            Node node = map.get(k);
            doubleList.removeNode(node);
            doubleList.insertTail(node);
            return node;
        }


        public void set(int k, int v) {
            if (map.containsKey(k)) {
                replace(k, v);
            } else {
                add(k, v);
            }
        }

        public int get(int k) {
            if (map.containsKey(k)) {
                Node node = getByK(k);
                return node.val;
            } else {
                return -1;
            }
        }
    }

    class LRU {
        int cap;
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

        public LRU(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            // 将 key 变为最近使用
            makeRecently(key);
            return cache.get(key);
        }

        public void set(int key, int val) {
            if (cache.containsKey(key)) {
                // 修改 key 的值
                cache.put(key, val);
                // 将 key 变为最近使用
                makeRecently(key);
                return;
            }

            if (cache.size() >= this.cap) {
                // 链表头部就是最久未使用的 key
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            // 将新的 key 添加链表尾部
            cache.put(key, val);
        }

        private void makeRecently(int key) {
            int val = cache.get(key);
            // 删除 key，重新插入到队尾
            cache.remove(key);
            cache.put(key, val);
        }
    }

    /*****************************************************************************************************************************/

    public int[] LRU(int[][] operators, int k) {
        // write code here
        if (operators == null || operators[0].length == 0 || k <= 0) {
            return new int[0];
        }
        int n = operators.length;
        int m = 0;
        for (int i = 0; i < n; i++) {
            int type = operators[i][0];
            if (type == 2) {
                m++;
            }
        }

        int[] res = new int[m];
        LRU lcu = new LRU(k);
        //LRU2 lcu2 = new LRU2(k);

        int idx = 0;
        for (int i = 0; i < n; i++) {
            int type = operators[i][0];
            if (type == 1) { //set
                lcu.set(operators[i][1], operators[i][2]);
            } else if (type == 2) {//get
                res[idx++] = lcu.get(operators[i][1]);
            }
        }
        return res;
    }

    public static class LRU2 {
        LinkedHashMap<Integer, Integer> map;
        int catacity;

        public LRU2(int k) {
            map = new LinkedHashMap<>();
            this.catacity = k;
        }

        public void set(int k, int v) {
            if (map.containsKey(k)) {
                //map.remove(k);
                map.put(k, v);
                return;
            }
            if (map.size() >= catacity) {
                map.remove(map.keySet().iterator().next());
                map.put(k, v);
            } else {
                map.put(k, v);
            }
        }

        public int get(int k) {
            if (!map.containsKey(k)) {
                return -1;
            }
            int v = map.get(k);
            map.remove(k);
            map.put(k, v);
            return v;
        }
    }
}
