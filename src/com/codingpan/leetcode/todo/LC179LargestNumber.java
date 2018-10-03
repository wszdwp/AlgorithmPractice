package com.codingpan.leetcode.todo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LC179LargestNumber {

//    Given a list of non negative integers, arrange them such that they form the largest number.
//
//    For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
//
//    Note: The result may be very large, so you need to return a string instead of an integer.
//
//    Credits:
//    Special thanks to @ts for adding this problem and creating all test cases.

    public String largestNumber(int[] nums) {
        if (nums.length == 0)   return "";
        
        StringBuilder sb = new StringBuilder();

        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsStr, new MyCustomComparator());

        for (String s : numsStr) {
            sb.append(s);
        }
        return sb.toString();
    }

    class MyCustomComparator implements Comparator<String> {
        @Override
        public int compare(String n1, String n2) {
            String num1 = n1 + n2;
            String num2 = n2 + n1;
            return num2.compareTo(num1);
        }
    }


    public static void main(String[] args) {
        // test cases
        int[] nums = {3, 30, 34, 5, 9};
        // {0, 0}  -> 0
        //
        LC179LargestNumber testLC179LargestNumber = new LC179LargestNumber();
        String largest = testLC179LargestNumber.largestNumber(nums);
        System.out.println("Largest (9534330) " + largest);
    }

}
