package com.codingpan.ms;

import java.util.ArrayList;

public class OTS20180212 {
    // 1. construct binary tree from in-order and pre-order traversal
    // 2. reverse Fibonacci with give two numbers
    //      eg: 80 50 -> 80 50 30 20 10 10 0
    // 3. n size of array of 1 ... n + 1, find missing number

    public static void buildTreeFromInPreOrder(int[] inOrder, int[] preOrder) {
        int len = inOrder.length;
        int i = 0;
        while (i < len) {
            int in = inOrder[i];
            int pre = preOrder[i];
            i++;
        }

    }

    public static ArrayList<Integer> reversedFibonacci(int n1, int n2) {
        ArrayList<Integer> ans = new ArrayList<>();
        while (n2 >= 0) {
            ans.add(n1);
            int temp = n2;
            n2 = n1 - n2;
            n1 = temp;
        }
        return ans;
    }

    public static int findMissingNumber(int[] nums) {
        boolean[] checker = new boolean[nums.length+2];
        for (int n : nums) {
            checker[n] = true;
        }
        for (int i = 1; i < checker.length; i++) {
            if (!checker[i])    return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n1 = 80, n2 = 50;
        ArrayList<Integer> reversedFi = reversedFibonacci(n1, n2);
        System.out.println("reversedFi " + reversedFi);

        int[] nums = {9, 7, 4, 5, 6, 2, 8, 1};
        int missed = findMissingNumber(nums);
        System.out.println("missed " + missed);
    }

}
