package com.codingpan.leetcode.passedOJ;


// [203. Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/)
//Remove all elements from a linked list of integers that have value val.
//
//Example
//Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
//Return: 1 --> 2 --> 3 --> 4 --> 5
//
//Credits:
//Special thanks to @mithmatt for adding this problem and creating all test cases.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */



public class LC203RemoveLinkedListElement {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode removeElements(ListNode head, int val) {
        if (head == null)	return null;
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode pre = fakeHead;
        ListNode cur = head;
        
        while (cur != null ) {
        	if (cur.val == val) {
        		ListNode temp = cur.next;
        		pre.next = temp;
        		cur = pre.next;
        	} else {
	        	pre = cur;
	        	cur = cur.next;
        	}
        }
        
        return fakeHead.next;
    }
}
