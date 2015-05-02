package com.codingpan.leetcode.passedOJ;

//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

//Note:
//Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
//The solution set must not contain duplicate triplets.
//  For example, given array S = {-1 0 1 2 -1 -4},

//  A solution set is:
//  (-1, 0, 1)
//  (-1, -1, 2)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeSum {
 public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {

 	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
 	Set set = new HashSet<ArrayList<Integer>>();

     if (num == null || num.length == 0) {
     	return res;
     }

     Arrays.sort(num);
     int len = num.length;

     for (int i = 0; i < len; i++) {
     	int j = i + 1;
     	int k = len - 1;

     	while (j < k) {
     		if (num[i] + num[j] + num[k] == 0) {
     			ArrayList<Integer> tmp = new ArrayList<Integer>();
     			tmp.add(num[i]);
     			tmp.add(num[j]);
     			tmp.add(num[k]);
     			if (!set.contains(tmp)){
     				res.add(tmp);
     				set.add(tmp);
     			}
     			j++;
     			k--;
     		} else if (num[i] + num[j] + num[k] < 0) {
     			j++;
     		} else {
     			k--;
     		}
     	}
     }

     return res;
 }

 public static void printList(ArrayList<ArrayList<Integer>> result) {
 	for (ArrayList<Integer> list : result) {
 		System.out.println(list);
 	}
 }

 public static void main(String[] args) {
 	int[] num = {-32, 2 , 4, 6, 8, 10, -2 , 5, 0, 31, 1, -3, -1, -5, -1};
 	int[] num2 = {0, 0, 0, 0};
 	int[] num3 = {-2,0,1,1,2};
 	printList(threeSum(num));
 	System.out.println();
 	printList(threeSum(num2));
 	System.out.println();
 	printList(threeSum(num3));

 }
}