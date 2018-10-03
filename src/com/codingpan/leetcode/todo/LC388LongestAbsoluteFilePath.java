package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

//Time complexity required: O(n) where n is the size of the input string.
public class LC388LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        return 0;
    }

    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
//        dir
//           subdir1
//              file1.ext
//              subsubdir1
//           subdir2
//              subsubdir2
//                  file2.ext
//        "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

        LC388LongestAbsoluteFilePath solu = new LC388LongestAbsoluteFilePath();
        int l = solu.lengthLongestPath(input);
        StdOut.println("32 " + l);

    }
}
