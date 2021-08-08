package com.codingpan.leetcode.high;

import com.codingpan.leetcode.util.ListNode;
import edu.princeton.cs.algs4.StdOut;

public class BloombergPhone {
    /**
     * given int and idx of two digits, swap
     *
     * eg: num = 654321, i = 2, j = 3, ans: 653421
     * @param num
     * @param i
     * @param j
     * @return
     */
    public int swapDigit(int num, int i, int j) {
        if (i < j) {
            int temp = i;
            i = j;
            j = temp;
        }

        int iDigit = (int)(num / Math.pow(10, i)) % 10;
        int jDigit = (int)(num / Math.pow(10, j)) % 10;

        int ans = num;
        ans += (iDigit-jDigit) * Math.pow(10, j);
        ans += (jDigit-iDigit) * Math.pow(10, i);
        return ans;
    }

    // eg: num = 654321, i = 3, j = 4, ans: 653421
    private int bruteForce(int num, int i, int j) {
        int totalDigits = 0;
        int n = num;
        while (n > 0) {
            n = n / 10;
            totalDigits++;
        }
        if (i > totalDigits || j > totalDigits) return num;

        int ans = 0;
        int count = 0;
        int factor = 1;
        int iFactor = 1;
        int jFactor = 1;
        int iDigit = 0;
        int jDigit = 0;
        while (num > 0) {
            int digit = num % 10;
            count++;
            if (totalDigits - count + 1 == j) {
                jDigit = digit;
                jFactor = factor;
            }
            else if (totalDigits - count + 1  == i) {
                iDigit = digit;
                iFactor = factor;
            }
            else {
                ans += digit * factor;
            }
            factor *= 10;
            num = num / 10;
        }
        ans += iDigit * jFactor;
        ans += jDigit * iFactor;

        return ans;
    }

    // eg: num = 654321, i = 3, j = 4, ans: 653421
    private int stringSwap(int num, int i, int j) {
        String intString = String.valueOf(num);
        char[] charArr = intString.toCharArray();
        char c = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = c;
        return Integer.valueOf(new String(charArr));
    }

    /**
     * [http://www.1point3acres.com/bbs/thread-302842-1-1.html]
     * leetcode 234 palindrome linked list
     * Given a singly linked list, determine if it is a palindrome.
     * @param
     */

    public boolean isPalindrome(ListNode head) {
        return false;
    }

    /**
     * 第二题，已知一个单调递增函数，
     * 请你用这个函数实现它的反函数。用二分法搜索，上下两个边界。 讲完思

     * @param args
     */

    public static void main(String[] args) {
        BloombergPhone solu = new BloombergPhone();

        // com.codingpan.test 1
        int num = 654321;
        int i = 2;
        int j = 3;
        int ans = solu.swapDigit(num, i, j);
        StdOut.println(ans);

        // com.codingpan.test 2
    }
}
