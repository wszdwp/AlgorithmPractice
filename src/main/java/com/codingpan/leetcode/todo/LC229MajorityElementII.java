package com.codingpan.leetcode.todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC229MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        if (nums == null) return ans;
        HashMap<Integer, Integer> cands = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (cands.containsKey(n)) {
                cands.put(n, cands.get(n) + 1);
            } else {
                if (cands.size() == 2) {
                    allCandsMinusOne(cands);
                } else {
                    cands.put(n, 1);
                }
            }
        }

        final int TIMES = nums.length / 3;
        HashMap<Integer, Integer> countMap = getCandsCountMap(nums, cands);
        for (Map.Entry<Integer, Integer> item : countMap.entrySet()) {
            Integer key = item.getKey();
            Integer val = item.getValue();
            if (val > TIMES) {
                ans.add(key);
            }
        }

        return ans;
    }

    private void allCandsMinusOne(HashMap<Integer, Integer> map) {
        List<Integer> removeList = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            Integer key = item.getKey();
            Integer val = item.getValue();
            if (val == 1) {
                removeList.add(key);
            }
            map.put(key, val-1);
        }
        for (Integer removeKey : removeList) {
            map.remove(removeKey);
        }
    }

    private HashMap<Integer, Integer> getCandsCountMap(int[] nums, HashMap<Integer, Integer> cands) {
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (cands.containsKey(n)) {
                if (countMap.containsKey(n)) {
                    countMap.put(n, countMap.get(n) + 1);
                } else {
                    countMap.put(n, 1);
                }
            }
        }
        return countMap;
    }
}
