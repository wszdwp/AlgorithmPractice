package com.codingpan.leetcode.TODO;

import java.util.ArrayList;
import java.util.List;

public class LeetcodeMatrix {
	/* 251 题目链接: https://leetcode.com/problems/flatten-2d-vector/
		Implement an iterator to flatten a 2d vector.
		For example,
		Given 2d vector =
		[
		  [1,2],
		  [3],
		  [4,5,6]
		]
		By calling next repeatedly until hasNext returns false, 
		the order of elements returned by next should be: [1,2,3,4,5,6].

		Hint:
		How many variables do you need to keep track?
			Two variables is all you need. Try with x and y.
			Beware of empty rows. It could be the first few rows.
			To write correct code, think about the invariant to maintain. What is it?
			The invariant is x and y must always point to a valid point in the 2d vector. Should you maintain your invariant ahead of time or right when you need it?
			Not sure? Think about how you would implement hasNext(). Which is more complex?
			Common logic in two different places should be refactored into a common method.
		Follow up:
		As an added challenge, 
		1. try to code it using only iterators in C++ or iterators in Java.
		2. add remove() */
		class Vector2D {
			private List<List<Integer>> vector2D = new ArrayList<>();
			private int row = 0;
			private int col = 0;
			
			public Vector2D(List<List<Integer>> myList) {
				vector2D = myList;
				row = 0;
				col = 0;
			}
			
			public int next() {
				return vector2D.get(row).get(col++);
			}
			
			public boolean hasNext() {
				while (row < vector2D.size()) {
					if (col < vector2D.get(row).size()) {
						return true;
					} else {
						row++;
						col = 0;
					}
				}
				return false;
			}
		}

}
