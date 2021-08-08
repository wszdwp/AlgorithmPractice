package com.codingpan.ms;

import com.codingpan.leetcode.util.Interval;
import com.codingpan.leetcode.util.ListNode;
import com.codingpan.leetcode.util.TreeNode;
import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class OTS2018 {
    /**
     *  phone # has two wrong format
     *  prefix - area - line  to area - prefix - line
     *  ###631####
     *  ###-631-####
     *
     *  convert to 631-###-###
     *
     * @param phoneNumbers
     */

    public void reformat(String[] phoneNumbers) {
        for (int i = 0; i < phoneNumbers.length; i++) {
            String num = phoneNumbers[i];
            if (num.length() != 10 && num.length() != 12) continue;
            if (num.length() == 10) {
                num = getFixLenString(num);
            }
            char[] numArr = num.toCharArray();
            for (int j = 0; j <= 2; j++) {
                swap(numArr, j, j+4);
            }
            phoneNumbers[i] = new String(numArr);
        }
    }

    private String getFixLenString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == 3 || i == 6) {
                sb.append("-");
            }
            sb.append(s.charAt(i));
        }
        return new String(sb);
    }

    private void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    /**
     * sort color
     * [2,0,2,1,1,0] -> [0,0,1,1,2,2]
     * [1,1,0,0,2,1,0] -> [0,0,0,1,1,1,2]
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int j = 0, k = nums.length - 1;
        for (int i = 0; i <= k; i++) {
            if (nums[i] == 0) {
                swap(nums, i, j);
                j++;
            }
            else if (nums[i] == 2) {
                swap(nums, i, k);
                i--;
                k--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int n = nums[i];
        nums[i] = nums[j];
        nums[j] = n;
    }

    /**
     * reverse first N notes in a single linked list
     * @param1 head
     * @param2 N
     */
    public ListNode reverseFirstN(ListNode head, int N) {
        if (head == null || head.next == null) return null;
        ListNode p = head;
        int count = 1;
        while (count < N && p != null) {
            p = p.next;
            count++;
        }
        ListNode newHead = null;
        if (p == null) {
            newHead = reverse(head, null);
        } else {
            ListNode head2 = p.next;
            newHead = reverse(head, head2);
            head.next = head2;
        }
        return newHead;
    }

    /**
     * reverse linked list from m to n
     * @param head
     * @param m
     * @param n
     * @return
     */

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        if (m > n || n < 0 || m < 0 || m == n) return head;

        int count = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode head1 = null;
        ListNode head2 = null;
        while (count <= n && curr != null) {
            if (count <  m) prev = prev.next;
            if (count == m) {
                head1 = curr;
            }
            if (count == n) {
                head2 = curr;
                break;
            }
            curr = curr.next;
            count++;
        }
        if (count <= n && curr == null) {
            ListNode segHead = reverse(head1, null);
            prev.next = segHead;
        } else {
            ListNode segTailNext = head2.next;
            ListNode segTail = prev.next;
            ListNode segHead = reverse(head1, head2.next);
            prev.next = segHead;
            segTail.next = segTailNext;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head, ListNode end) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != end) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    /**
     * lc 402 remove k digits to get a smallest number
     * @param num, k
     */
    public String removeKdigits(String num, int k) {
        if (k <= 0) return num;
        if (num.length() <= k) return "0";

        Stack<Integer> stk = new Stack<Integer>();
        for (int i = 0; i < num.length(); i++) {
            Integer n = Integer.valueOf(num.substring(i, i+1));
            while (!stk.isEmpty() && stk.peek() > n && k > 0) {
                stk.pop();
                k--;
            }
            if (stk.isEmpty() && n == 0) continue;
            stk.push(n);
        }
        while (!stk.isEmpty() && k != 0) {
            stk.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            int n = stk.pop();
            sb.append(n);
        }
        if (sb.length() == 0) sb.append("0");
        return new String(sb.reverse());
    }

    /**
     * while loop make a == x, b == y
     * @params a, b, x, y
     */
    public void makeNumbersMatch(int a, int b, int x, int y) {
        while(a != x || b != y) {
            if ( a != x) {
                if (a > x) {
                    a--;
                } else {
                    a++;
                }
            }
            if (b != y) {
                if (b > y) {
                    b--;
                } else {
                    b++;
                }
            }
        }
    }

    /**
     * unlimited input, find kth greatest element at any time
     */
    public int getKthElement(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        StdOut.println(pq.size());
        return pq.poll();
    }

    /**
     * find top kth freq element
     */
    public List<Integer> getTopKFreqElement(int[] nums, int k) {
        class Elem {
            int val;
            int count;
            public Elem(int v, int cnt) {
                val = v;
                count = cnt;
            }
        }
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> hMap = new HashMap<>();
        for (int n : nums) {
            if (hMap.containsKey(n)) {
                hMap.put(n, hMap.get(n) + 1);
            } else {
                hMap.put(n, 1);
            }
        }
        PriorityQueue<Elem> pq = new PriorityQueue<>(k, new Comparator<Elem>() {
            @Override
            public int compare(Elem o1, Elem o2) {
                return o1.count - o2.count;
            }
        });
        for (Map.Entry<Integer, Integer> item : hMap.entrySet()) {
            Elem elem = new Elem(item.getKey(), item.getValue());
            StdOut.println("num " + item.getKey() + " 's count is " + item.getValue());
            pq.offer(elem);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            ans.add(pq.poll().val);
        }
        return ans;

    }

    /**
     * lc88 merge two sorted array
     * @params nums1, m, nums2, n
     */
    public void mergeTwoSorted(int[] nums1, int m, int[] nums2, int n) {
        int e = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[e] = nums1[i];
                i--;
            } else {
                nums1[e] = nums2[j];
                j--;
            }
            e--;
        }
        while (i >= 0) {
            nums1[e] = nums1[i];
            e--;
            i--;
        }
        while (j >= 0) {
            nums1[e] = nums2[j];
            e--;
            j--;
        }
    }

    private void mergeTwoSortedClean(int[] nums1, int m, int[] nums2, int n) {
        while (m > 0 && n > 0) {
            if (nums1[m-1] > nums2[n-1]) {
                nums1[m+n-1] = nums1[m-1];
                m--;
            } else {
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }
        while (n > 0) {
            nums1[m+n-1] = nums2[n-1];
            n--;
        }
    }

    /**
     * build binary search tree from in order and pre order
     * @params in, pre
     */

    public TreeNode createTreeFromInPre(int[] in, int[] pre) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inMap.put(in[i], i);
        }
        return inPreHelper(in, 0, in.length-1, pre, 0, pre.length-1, inMap);
    }

    private TreeNode inPreHelper(int[] in, int inL, int inR, int[] pre, int preL, int preR, HashMap<Integer, Integer> inMap) {
        if (preL > preR) return null;
        int val = pre[preL];
        int inPos = inMap.get(val);
        TreeNode root = new TreeNode(val);
        root.left = inPreHelper(in, inL, inPos-1, pre, preL+1, preL+inPos-inL, inMap);
        root.right = inPreHelper(in, inPos+1, inR, pre, preL+inPos-inL+1, preR, inMap);
        return root;
    }

    /**
     * reverse fibonacci series
     * @params a, b
     */
    public List<Integer> reverseFibonacci(int a, int b) {
        List<Integer> res = new ArrayList<>();
        if (a < 0 || b < 0) return res;
        int n1 = a;
        int n2 = b;
        if (a < b) {
            n1 = b;
            n2 = a;
        }
        while (n2 >= 0) {
            res.add(n1);
            int temp = n2;
            n2 = n1 - n2;
            n1 = temp;
        }
        return res;
    }

    /**
     * meeting room 2
     * @param intervals
     */
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        if (intervals.length == 1) return 1;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 1;
        pq.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            Interval interval = intervals[i];
            if (interval.start < pq.peek()) {
                count++;
            } else {
                pq.poll();
            }
            pq.offer(interval.end);
        }

        return count;
    }

    /**
     * flip diaganal matrix
     * @param m
     */
    private void flipMatrix(int[][] m) {
        int tR = 0, tC = 0;
        int dR = 0, dC = 0;
        int endR = m.length-1, endC = m[0].length-1;
        while (tR != endR || tC != endC) {
            swap(m, tR, tC, dR, dC);
            if (tR == endR) {
                tR = endR;
                tC++;
            } else {
                tR++;
                tC = 0;
            }
            if (dC == endC) {
                dR++;
                dC = endC;
            } else {
                dR = 0;
                dC++;
            }
        }
    }

    private void swap(int[][] m, int tR, int tC, int dR, int dC) {
        while (tR != dR && tC != dC) {
            int temp = m[tR][tC];
            m[tR][tC] = m[dR][dC];
            m[dR][dC] = temp;
            if (tR - 1 == dR && tC + 1 == dC) return;
            tR--;
            tC++;
            dR++;
            dC--;
        }
    }

    /**
     * find continuous substring
     *
     * @param s
     */
    public List<String> findContinuousSubstring(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() <= 1 ) return res;
        int l = 0, r = 1;
        while (r < s.length()) {
            while (r < s.length() && s.charAt(r) == s.charAt(r-1) + 1) {
                res.add(s.substring(l, r+1));
                r++;
            }
            l++;
            while (l < r) {
                if (r - l > 1) res.add(s.substring(l, r));
                l++;
            }
            r = l + 1;
        }
        return res;
    }

    /**
     * lc171 excel sheet col number
     * @param s
     */
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
        }
        return res;
    }

    /**
     * find the 2nd largest element to a given val in BST
     * @params root, n
     */
    public int findSecondLargestInBST(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        dfs(root, k, res);
        StdOut.println();
        if (res.size() == 3) {
            return res.get(2);
        } else {
            return 0;
        }
    }

    private void dfs(TreeNode root, int k, List<Integer> res) {
        if (root == null) return;
        dfs(root.left, k, res);
        if (root.val >= k && res.size() < 3) {
            res.add(root.val);
        }
        StdOut.print(root.val + ",");
        dfs(root.right, k, res);
    }

    /**
     * lc443 string compress in place
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        if (chars.length <= 1) return chars.length;

        int pos = 0;
        int i = 0;
        int j = 0;
        while (i < chars.length) {
            if (j == chars.length || chars[j] != chars[i]) {
                chars[pos++] = chars[i];
                if (j - i <= 1) {
                    i = j;
                } else {
                    String charCountStr = String.valueOf(j-i);
                    for (int k = 0; k < charCountStr.length(); k++) {
                        chars[pos++] = charCountStr.charAt(k);
                    }
                    i = j;
                }
            } else {
                j++;
            }
        }
        return pos;
    }

    // unfinished needs debug
    public String decode(char[] chars, int e) {
        int pos = chars.length - 1;
        int i = e;
        int j = e;
        while (i >= 0 && i >= 0) {
            if (j == 0 || isChar(chars[j])) {
                if (j - i >= 1) {
                    int count = getCount(chars, j+1, i);
                    for (int k = 0; k < count; k++) {
                        chars[pos--] = chars[j];
                    }
                }
                j--;
                i = j;
            } else {
                j--;
            }
        }

        return new String(chars);
    }

    private boolean isChar(char c) {
        return  (c - 'a' >= 0) && (c - 'a' <= 26);
    }

    private int getCount(char[] arr, int i, int j) {
        StringBuilder sb = new StringBuilder();
        while (i <= j) {
            sb.append(arr[i]);
            i++;
        }
        return Integer.valueOf(new String(sb));
    }

    /**
     * validate BST
     * @param root
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public boolean isValidBST(TreeNode root, double min, double max) {
        if (root == null)   return true;

        if (root.val <= min || root.val >= max)    return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    /**
     * lc61 rotate list
     * Given a linked list, rotate the list to the right by k places, where k is non-negative.
     *
     * Input: 1->2->3->4->5->NULL, k = 2
     * Output: 4->5->1->2->3->NULL
     * Explanation:
     * rotate 1 steps to the right: 5->1->2->3->4->NULL
     * rotate 2 steps to the right: 4->5->1->2->3->NULL
     *
     * example2
     * Input: 0->1->2->NULL, k = 4
     * Output: 2->0->1->NULL
     *
     * Explanation:
     * rotate 1 steps to the right: 2->0->1->NULL
     * rotate 2 steps to the right: 1->2->0->NULL
     * rotate 3 steps to the right: 0->1->2->NULL
     * rotate 4 steps to the right: 2->0->1->NULL
     * @params head, n
     */
    public ListNode rotateRight(ListNode head, int n) {
        if (n == 0 || head == null)
            return head;

        int len = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            len++;
        }

        if (n == len)
            return head;

        n = len - n % len;
        p.next = head;

        int step = 0;
        while (step < n) {
            p = p.next;
            step++;
        }
        head = p.next;
        p.next = null;

        return head;
    }

    /**
     * lc200 number of islands
     * @param grid
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length==0 || grid[0].length == 0) return 0;

        boolean[][] used = new boolean[grid.length][grid[0].length];
        int numOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!used[i][j] && grid[i][j] == '1') {
                    searchIslands(grid, i, j, used);
                    numOfIslands++;
                }
            }
        }

        return numOfIslands;
    }

    private void searchIslands(char[][] grid, int i, int j, boolean[][] used) {
        if (i == grid.length || j == grid[0].length || i < 0 || j < 0) return;
        if (!used[i][j] && grid[i][j] == '1') {
            used[i][j] = true;
            searchIslands(grid, i+1, j, used);
            searchIslands(grid, i-1, j, used);
            searchIslands(grid, i, j-1, used);
            searchIslands(grid, i, j+1, used);
        }
    }

    /**
     * lc151 reverse words in a string
     */
    public String reverseWords(String s) {
        if (s == null || s.length() <= 1) return s;

        char[] arr = s.trim().toCharArray();
        reverse(arr, 0, arr.length-1);
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == ' ') {
                reverse(arr, i, j-1);
                i = j + 1;
            }
        }
        reverse(arr, i, arr.length-1);

        return new String(arr);
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
            i++;
            j--;
        }
    }

    /**
     * compare version number
     * @params v1, v2
     */
    public int compareVersion(String v1, String v2) {
//        if (!v1.contains(".")) {
//            v1 = new String(v1 + ".0");
//        }
//        if (!v2.contains(".")) {
//            v2 = new String(v2 + ".0");
//        }

        String[] s1 = v1.split("\\.");
        String[] s2 = v2.split("\\.");
        int i = 0;
        int len = Math.max(s1.length, s2.length);
        while (i < len) {
            Integer d1 = i < s1.length ? Integer.valueOf(s1[i]) : 0;
            Integer d2 = i < s2.length ? Integer.valueOf(s2[i]) : 0;
            if (d1 > d2) {
                return 1;
            }
            else if (d1 < d2) {
                return -1;
            }
            else {
                i++;
            }
        }
        return 0;
    }

    /**
     * index array, next greater element's index distwance as the output element
     *
     * @param arr
     */
    public int[] generateClosestGreaterArray(int[] arr) {
        if (arr == null || arr.length == 0) return new int[0];
        int[] res = new int[arr.length];
        Stack<Integer> stk = new Stack<>();
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stk.isEmpty() && arr[stk.peek()] < arr[i]) {
                hMap.put(stk.pop(), i);
            }
            stk.push(i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (hMap.containsKey(i)) {
                res[i] = hMap.get(i) - i;
            }
        }
        return res;
    }

    /**
     * reorder string array to get minimum diff char count pair
     * eg:
     * input: ["car", "bat", "bar"] total sum of neighbor char diff is 2 + 1 = 3
     * output: ["car", "bar", "bat"]  1 + 1  = 2
     * @param words
     */
    public void minCharCountSort(String[] words) {

    }

    // wrong , need to rethink
    private int getCharDiff(String word1, String word2) {
        if (word1 == null && word2 == null) return 0;
        if (word1 == null || word1.length() == 0) return word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();

        int[] charCounts = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            charCounts[word1.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < word2.length(); i++) {
            int j = word2.charAt(i) - 'a';
            if (charCounts[j] > 0) {
                charCounts[j] -= 1;
            } else {
                charCounts[j] += 1;
            }
        }
        int totalDiffCount = 0;
        for (int n : charCounts) {
            totalDiffCount += n;
        }
        return totalDiffCount/2;
    }

    public static void main(String[] args) {
        OTS2018 solu = new OTS2018();
        // format phone no
//        String[] phoneNumbers = {"1236314455", "1236315566", "123-631-4825", "123-6-4825", "123"};
//        solu.reformat(phoneNumbers);
//        for (String num : phoneNumbers) {
//            StdOut.print(num + " ");
//        }
//        StdOut.println();

        //sort color
//        int[] colors = {1,1,0,0,2,1,0};
//        solu.sortColors(colors);
//        Utility.printArray(colors);

        // reverse N notes list
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        ListNode head = Utility.createLinkedList(nums);
//        Utility.printLinkedList(head);
////        head = solu.reverseFirstN(head, 4);
//        head = solu.reverseBetween(head, 7, 9);
//        Utility.printLinkedList(head);

        // lc 402
//        String[] nums = {"1432219", "10200", "10", "10", "112"};
//        int[] ks = {3, 1, 2, 1, 1};
//        for (int i = 0; i < nums.length; i++) {
//            StdOut.println(solu.removeKdigits(nums[i], ks[i]));
//        }

        // get kth element
//        int[] numbers = {1, 2, 4, 6, 7, 8, 2, 5, 6, 3, 6, 3, 8, 9};
//        int k = 5;
//        Arrays.sort(numbers);
//        Utility.printArray(numbers);
//        StdOut.println("kth elem = " + solu.getKthElement(numbers, k));

        // merge two sorted array
//        int[] nums1 = {1,3,4,0,0,0};
//        int m = 3;
//        int[] nums2 = {2, 5, 6};
//        int n = 3;
//        solu.mergeTwoSortedClean(nums1, m, nums2, n);
//        Utility.printArray(nums1);

        //create tree form in and pre

        // reverse fib
//        int a = 34, b = 22;
//        List<Integer> res = solu.reverseFibonacci(a, b);
//        Utility.printList(res);

        //flip matrix
//        for (int i = 1; i <= 5; i++) {
//            int[][] matrix = Utility.generateMatrix(i, i);
//            Utility.printMatrix(matrix);
//            solu.flipMatrix(matrix);
//            Utility.printMatrix(matrix);
//        }

        // find continous substring
//        String s = "BCCDEG";
//        //String s = "ABCKJKLMNPPOPQ";
//        List<String> res = solu.findContinuousSubstring(s);
//        Utility.printStringList(res);

        // excel sheet col num
//        String[] excelCols = {"A", "AB", "ZY"};
//        for (String col : excelCols) {
//            StdOut.print(solu.titleToNumber(col) + ", ");
//        }
//        StdOut.println();

        // com.codingpan.test 2nd largest val to a given val in BST
//        int[] arr = {1, 3, 4, 5, 10, 14};
//        TreeNode root = Utility.createTree(arr);
//        //Utility.printTree(root, Utility.TreeOrder.IN);
//        StdOut.println(solu.findSecondLargestInBST(root, 4));

        // com.codingpan.test find char
//        String alphabeta = "abcdefghijklmnopqrstuvwxyz";
//        for (int i = 0; i < alphabeta.length(); i++) {
//            StdOut.println(solu.isChar(alphabeta.charAt(i)));
//        }
//        String s = "aabbccc";
//        char[] sArr = s.toCharArray();
//        int e = solu.compress(sArr);
//        StdOut.println("end index = " + e);
//        StdOut.println(solu.decode(sArr, e));

//        char[][] grid = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'},
//        };
//        StdOut.println(solu.numIslands(grid));

        // reverse words in a string
//        String s = " the sky is blue ";
////        String[] ss = s.trim().split(" ");
////        for (String a : ss) StdOut.print(a + ",");
//        StdOut.println(solu.reverseWords(s));

        // find top k freq
//        int[] nums = {2, 3, 3, 3, 2, 2, 1, 4, 6, 7, 7, 8, 8, 8, 6, 9, 10};
//        int k = 4;
//        List<Integer> topKList = solu.getTopKFreqElement(nums, k);
//        Utility.printList(topKList);

        // compare version
//        String v1 = "1.0.0.0.0.1";
//        String v2 = "1.0.0";
//        String v1 = "1";
//        String v2 = "1.0.1";
//        StdOut.println(solu.compareVersion(v1, v2));

        //
//        int[] nums = {2, 5, 3, 4, 7, 23, 15, 7, 16, 25};
//        int[] distanceArr = solu.generateClosestGreaterArray(nums);
//        Utility.printArray(distanceArr);

        String[] words = {"carr", "bat", "bar"};
        for (int i = 0; i < words.length-1; i++) {
            int diff = solu.getCharDiff(words[i], words[i+1]);
            StdOut.print(diff + ", ");
        }
        StdOut.println();

        solu.minCharCountSort(words);
        for (String word : words) StdOut.print(word + ", ");
    }
}
