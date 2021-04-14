package com.company.trie;

import java.util.TreeMap;

public class Trie {
    private Node root;
    private int size;

    private class Node{
        boolean isWord;
        TreeMap<Character, Node> next;
    }

    public Trie() {
        root = new Node();
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0 ; i < word.length(); i ++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        if (cur.isWord) {
            cur.isWord = true;
            size ++;
        }

    }
}
