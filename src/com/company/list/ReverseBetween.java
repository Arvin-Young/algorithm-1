package com.company.list;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode L = null;
        int l = 1;
        while (cur != null) {
            if (l < m)
                l ++;
            else {//找到第一个节点
                ListNode next = cur.next;

            }
        }

        return null;
    }
}
