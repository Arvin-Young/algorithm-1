package com.company.list;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static void print(ListNode node) {
        ListNode cur = node;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public static ListNode generateListNode(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            cur.next = node;
            cur = node;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode node = generateListNode(arr);
        print(node);
    }
}
