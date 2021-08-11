package com.codingpan.ms;

import com.codingpan.leetcode.util.ListNode;
import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

public class OnSite201806 {
    /**
     * find max val in linkedList with recursive way
     */
    public int findMaxInList(ListNode head) {
        if (head == null) return 0;
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        findMaxInListRecur(head, res);
        return res[0];
    }

    private void findMaxInListRecur(ListNode head, int[] res) {
        if (head == null) return;
        res[0] = Math.max(head.val, res[0]);
        findMaxInListRecur(head.next, res);
    }

    public static void main(String[] args) {
        OnSite201806 solu = new OnSite201806();
        int[] arr = {3, 4, 56, 78, 6, 2, 23, 43, 23, 2, 1, 100, 33, 44, 600};
        ListNode head = Utility.createLinkedList(arr);
        int maxVal = solu.findMaxInList(head);
        StdOut.println("max = " + maxVal);
    }
}
