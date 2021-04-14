package com.company.list;

public class DeleteNode {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 9};
        ListNode node = ListNode.generateListNode(arr);
        ListNode.print(node);
        ListNode node1 = deleteNode(node, 5);
        ListNode.print(node1);
    }

    public static ListNode deleteNode(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
