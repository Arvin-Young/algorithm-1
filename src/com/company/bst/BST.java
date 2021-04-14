package com.company.bst;

public class BST<E extends Comparable<E>> {
    private class Node{
        E e;
        Node left;
        Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public void add(E val) {
        if (root == null) {
            root = new Node(val);
            return;
        }
        Node cur = root;

        while (cur != null) {
            if (val.compareTo(cur.e) < 0)
                if (cur.left != null)
                    cur = cur.left;
                else {
                    cur.left = new Node(val);
                    return;
                }
            else if (val.compareTo(cur.e) > 0)
                if (cur.right != null)
                    cur = cur.right;
                else {
                    cur.right = new Node(val);
                    return;
                }
            else
                return;
        }
    }

    public void print() {
        pre(root);
    }

    public void pre(Node node) {
        if (node == null) {
            return;
        }
        pre(node.left);
        System.out.print(node.e + " ");
        pre(node.right);
    }

    public static void main(String[] args) {
        int[] array = {5, 7, 6, 2, 9, 4, 1};
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < array.length; i ++) {
            bst.add(array[i]);
        }
        bst.print();
    }
}
