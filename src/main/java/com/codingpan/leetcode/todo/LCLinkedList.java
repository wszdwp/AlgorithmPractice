package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.ListNode;
import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

public class LCLinkedList {

    public void printCommonPart(ListNode head1, ListNode head2) {
        ListNode head = head1;
        while (head1 != null && head2 != null) {
            if (head1.val == head2.val) {
                StdOut.print(head1.val + ",");
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.val < head2.val) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }
        StdOut.println();
    }

    public ListNode removeLastKthNode(ListNode head, int lastKth) {
        if (head == null || lastKth < 1) return head;
        ListNode walker = head;
        ListNode runner = head;
        ListNode pre = head;
        int count = 0;
        while (runner != null && walker != null) {
            runner = runner.next;
            count++;
            if (count > lastKth) {
                walker = walker.next;
                if (count > lastKth + 1) {
                    pre = pre.next;
                }
            }
        }
        pre.next = walker.next;
        return walker;
    }

    public static void main(String[] args) {
        LCLinkedList solu = new LCLinkedList();
        int[] arr1 = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[] arr2 = {2, 3, 8, 9, 11, 12, 13};
        ListNode head1 = Utility.createLinkedList(arr1);
        ListNode head2 = Utility.createLinkedList(arr2);
        // solu.printCommonPart(head1, head2);

        ListNode lastKthNode = solu.removeLastKthNode(head1, 1);
        StdOut.println(lastKthNode.val);
    }
}
