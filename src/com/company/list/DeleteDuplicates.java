package com.company.list;

public class DeleteDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 4, 5};
        ListNode node = ListNode.generateListNode(arr);
        ListNode.print(node);
        ListNode node1 = deleteDuplicates(node);
        ListNode.print(node1);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode c = dummyHead.next;
        ListNode n = c.next;

        while (c != null) {
            if (n == null || c.val != n.val)
                if (p.next != c)
                    p.next = n;
                else
                    p = c;

            c = n;

            if (n != null)
                n = n.next;
        }
        return dummyHead.next;
    }
}
