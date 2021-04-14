package com.company.list;

import java.util.*;

public class LRUCache {
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            //最近使用，移到头结点处
            if (node == tail) {
                tail = node.prev;
            }
            if (node != head) {
                node.prev.next = node.next;
                if (node.next != null) {
                    node.next.prev = node.prev;
                }
                node.next = head;
                head.prev = node;
                head = node;
            }
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        int size = map.size();
        if (size + 1 > capacity) {
            map.remove(tail.val);
            tail = tail.prev;
        }
        Node node = new Node(key, value);
        map.put(key, node);
        if (head != null) {
            node.next = head;
            head.prev = node;
        } else {
            tail = node;
        }
        head = node;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 0); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));// 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));// 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));// 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));// 返回 3
        System.out.println(lRUCache.get(4));// 返回 4
    }
}
