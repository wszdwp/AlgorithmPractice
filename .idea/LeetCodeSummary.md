# 总结

## Array  
原型  
169 数组中找到过半的数字
扩展  
229 数组中找到出现次数大于N/K的数字
Next challenges: 
missing range
3Sum smaller
1-bit and 2-bit char

Sum
2Sum  
3Sum  
3Sum cloest  

## Tree
103. Binary Tree Zigzag Level Order Traversal
Next challenges: 
Number of Connected Components in an Undirected Graph
Mini Parser
Delete Node in a BST


## LinkedList
86 Partition List  

142. Linked List Cycle II （one time pass using times of meet to flag and change speed of fast pointer)
Next challenges: 
3Sum 
SmallerIntersection of Two Arrays II
Plus One Linked List


## 重复元素的问题  
两个index， 一个做遍历，另外一个追踪当前无重复值的位置，
遍历index不断移动，来比较前一相邻元素，不同时，
赋值给赋值index， 赋值index移动一位
扩展：可以允许最多ｋ重复值
相同时，如果小于k次，同样赋值，赋值index移动一位，直至出现K次
26 Remove Duplicates from Sorted Array
80 Remove Duplicates from Sorted Array II 


83 Remove Duplicates from Sorted List  
82. Remove Duplicates from Sorted List II 

316	Remove Duplicate Letters

用Set判断重复元素
217 Contains Duplicate  

用Hashmap判断重复元素，key存nums[i], val 存 index i
优化空间：HashSet 存nums[i], 当元素超出k个时，移除最前面的元素，维持一个size = k + 1的set
219 Contains Duplicate II

进阶问题：
220 Contains Duplicate III

287	Find the Duplicate Number
442 Find All Duplicates in an Array

381	Insert Delete GetRandom O(1) - Duplicates allowed  

609	Find Duplicate File in System

182	Duplicate Emails
196	Delete Duplicate Emails

652	Find Duplicate Subtrees

## Shortest word distance  
243	Shortest Word Distance    			
244	Shortest Word Distance II    			
612	Shortest Distance in a Plane 	
613	Shortest Distance in a Line	
245	Shortest Word Distance III   

## Math problem
7. Reverse Integer
Next challenges: 
Nth DigitComplex Number MultiplicationFraction Addition and Subtraction 