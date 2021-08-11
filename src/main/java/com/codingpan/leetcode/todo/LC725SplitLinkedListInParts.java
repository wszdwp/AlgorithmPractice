package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.ListNode;
import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

public class LC725SplitLinkedListInParts {
    //	Given a (singly) linked list with head node root, write a function to split the linked list
    // into k consecutive linked list "parts".
    //
    //	The length of each part should be as equal as possible: no two parts should have a size
    // differing by more than 1. This may lead to some parts being null.
    //
    //	The parts should be in order of occurrence in the input list, and parts occurring earlier
    // should always have a size greater than or equal parts occurring later.
    //
    //	Return a List of ListNode's representing the linked list parts that are formed.
    //
    //	Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
    //	Example 1:
    //	Input:
    //	root = [1, 2, 3], k = 5
    //	Output: [[1],[2],[3],[],[]]
    //	Explanation:
    //	The input and each element of the output are ListNodes, not arrays.
    //	For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and
    // root.next.next.next = null.
    //	The first element output[0] has output[0].val = 1, output[0].next = null.
    //	The last element output[4] is null, but it's string representation as a ListNode is [].
    //	Example 2:
    //	Input:
    //	root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
    //	Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
    //	Explanation:
    //	The input has been split into consecutive parts with size difference at most 1, and earlier
    // parts are a larger size than the later parts.
    //	Note:
    //
    //	The length of root will be in the range [0, 1000].
    //	Each value of a node in the input will be an integer in the range [0, 999].
    //	k will be an integer in the range [1, 50].
    //	Discuss

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
     * x) { val = x; } }
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (k <= 0) return new ListNode[0];
        if (root == null) return new ListNode[k];
        int len = 0;
        ListNode p = root;
        while (p != null) {
            p = p.next;
            len++;
        }
        ListNode[] res = new ListNode[k];
        int avgLen = 1;
        int remainder = 0;
        if (len > k) {
            avgLen = len / k;
            remainder = len % k;
        }

        p = root;
        ListNode segHead;
        int segLen = 0;
        int idx = 0;
        while (p != null) {
            if (segLen == 0) {
                segHead = p;
                res[idx++] = segHead;
                segLen = remainder > 0 ? avgLen + 1 : avgLen;
                remainder--;
            }
            segLen--;
            if (segLen == 0) {
                ListNode temp = p;
                p = p.next;
                temp.next = null;
            } else {
                p = p.next;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC725SplitLinkedListInParts solu = new LC725SplitLinkedListInParts();
        //		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //		int k = 3;

        int[] arr = {1, 2, 3, 4};
        int k = 3;
        ListNode head = Utility.createLinkedList(arr);
        head = null;
        ListNode[] res = solu.splitListToParts(head, k);
        StdOut.print("[");
        for (int i = 0; i < res.length; i++) {
            ListNode h = res[i];
            StdOut.print("[");
            while (h != null) {
                StdOut.print(h.val + "->");
                h = h.next;
            }
            StdOut.print("NULL], ");
        }
        StdOut.println("]");
    }
}
