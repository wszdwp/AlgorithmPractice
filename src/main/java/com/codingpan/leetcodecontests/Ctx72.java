package com.codingpan.leetcodecontests;

import com.codingpan.leetcode.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class Ctx72 {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        if (S == null || S.isEmpty()) return res;
        // dfsPermute(S.toCharArray(), 0, res);
        bfsPermute(S.toCharArray(), res);
        return res;
    }

    private void dfsPermute(char[] arr, int start, List<String> res) {
        res.add(new String(arr));
        for (int i = start; i < arr.length; i++) {
            char c = arr[i];
            if (c >= 'a' && c <= 'z') {
                arr[i] = Character.toUpperCase(c);
                dfsPermute(arr, i + 1, res);
                arr[i] = c;
            } else if (c >= 'A' && c <= 'Z') {
                arr[i] = Character.toLowerCase(c);
                dfsPermute(arr, i + 1, res);
                arr[i] = c;
            } else {
                continue;
            }
        }
    }

    private void bfsPermute(char[] arr, List<String> res) {
        res.add(new String(arr));
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c >= 'a' && c <= 'z') {
                int size = res.size();
                for (int j = 0; j < size; j++) {
                    char[] cArr = res.get(j).toCharArray();
                    cArr[i] = Character.toUpperCase(c);
                    res.add(new String(cArr));
                }
            } else if (c >= 'A' && c <= 'Z') {
                int size = res.size();
                for (int j = 0; j < size; j++) {
                    char[] cArr = res.get(j).toCharArray();
                    cArr[i] = Character.toLowerCase(c);
                    res.add(new String(cArr));
                }
            }
        }
    }

    public static void main(String[] args) {
        Ctx72 solu = new Ctx72();
        String S = "a1b2";
        List<String> res = solu.letterCasePermutation(S);
        Utility.printList(res);
    }
}
