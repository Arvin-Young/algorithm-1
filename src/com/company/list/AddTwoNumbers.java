package com.company.list;

/**
 * 面试题 02.05. 链表求和
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = ListNode.generateListNode(new int[]{7, 1, 6});
        //ListNode l2 = ListNode.generateListNode(new int[]{5, 9, 2});

        ListNode node = addTwoNumbers(l1, null);
        ListNode.print(node);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode cur = new ListNode(-1);
        ListNode head = cur;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            int val = sum % 10;
            ListNode res = new ListNode(val);
            cur.next = res;
            cur = res;
            carry = sum / 10;
        }
        if (carry != 0) {
            ListNode res = new ListNode(carry);
            cur.next = res;
        }

        return head.next;
    }
}
