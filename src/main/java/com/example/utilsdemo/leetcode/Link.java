package com.example.utilsdemo.leetcode;

import java.util.HashSet;

/**
 * @Author: xy
 * @Date: 2024-12-16 09:38
 * @Description:
 */
public class Link {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head.next != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return getNextNode(l1, l2, 0);
    }

    private ListNode getNextNode(ListNode l1, ListNode l2, int carry) {
        ListNode head = null;
        if (l1 != null || l2 != null || carry != 0) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = (v1 + v2 + carry) % 10;
            carry = (v1 + v2 + carry) / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            head = new ListNode(sum, getNextNode(l1, l2, carry));
        }
        return head;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }


        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }
}
