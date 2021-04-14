package com.company.list;

public class YYList {
    private static class Node<E> {
        E e;
        Node next;

        public Node(E e) {
            this.e = e;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        node1.next = node2;
        Node<Integer> node3 = new Node<>(3);
        node2.next = node3;
        Node<Integer> node4 = new Node<>(4);
        node3.next = node4;

        Node<Integer> temp = node1;
        while (temp != null) {
            System.out.println(temp.e);
            temp = temp.next;
        }
    }

}
