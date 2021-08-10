package com.codingpan.leetcode.passedOJ;

import com.codingpan.leetcode.util.ListNode;
import com.codingpan.leetcode.util.Utility;

public class LC086PartitionList {
  /**
   * Input: head = 1->4->3->2->5->2, x = 3 Output: 1->2->2->4->3->5
   *
   * @param head
   * @param x
   * @return ListNode
   */
  public ListNode partition(ListNode head, int x) {
    ListNode dummyHead1 = new ListNode(0);
    ListNode dummyHead2 = new ListNode(0);
    ListNode p1 = dummyHead1;
    ListNode p2 = dummyHead2;

    ListNode p = head;
    while (p != null) {
      if (p.val < x) {
        p1.next = p;
        p1 = p;
      } else {
        p2.next = p;
        p2 = p;
      }
      p = p.next;
    }
    p2.next = null;
    p1.next = dummyHead2.next;
    return dummyHead1.next;
  }

  public static void main(String[] args) {
    //        int[] nums = {1, 4, 3, 2, 5, 1, 2, 1};
    //        int x = 3;
    //        int[] nums = {1, 2, 3};
    //        int x = 1;
    int[] nums = {3, 2, 1};
    int x = 2;
    ListNode head = Utility.createLinkedList(nums);
    Utility.printLinkedList(head);

    LC086PartitionList solu = new LC086PartitionList();
    ListNode h = solu.partition(head, x);
    Utility.printLinkedList(h);
  }
}
