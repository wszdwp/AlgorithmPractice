package com.codingpan.gg;

import com.codingpan.leetcode.util.Utility;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class DamageCardGame {
    // 比如  total_money =5, total_damage=5, cost=[1,4,5], damage=[2,3,2] return True。
    // 因为你可以买第一张和第二张花5块 造成的damage是5.
    //
    // total_money=10, total_damage=10, cost=[5,5,8], damage=[4,5,9] return False.
    public boolean canCauseDamage(int totalDamage, int totalMoney, int[] costs, int[] damages) {
        return helper(totalDamage, totalMoney, costs, damages, 0, new ArrayList<Integer>());
    }

//    private boolean helper(int totalD, int totalM, int[] costs, int[] damages, int start) {
//        if (totalD == 0 && totalM >= 0) {
//            return true;
//        } else {
//            if (start == damages.length || totalD < 0 || totalM < 0) {
//                return false;
//            } else {
//                for (int i = start; i < damages.length; i++) {
//                    if (helper(totalD - damages[i], totalM - costs[i], costs, damages, i + 1)) return true;
//                }
//                return false;
//            }
//        }
//    }

    private boolean helper(int totalD, int totalM, int[] costs, int[] damages, int start, List<Integer> path) {
        if (totalD == 0 && totalM >= 0) {
            Utility.printList(path);
            return true;
        } else {
            if (start == damages.length || totalD < 0 || totalM < 0) {
                return false;
            } else {
                for (int i = start; i < damages.length; i++) {
                    path.add(i);
                    if (helper(totalD - damages[i], totalM - costs[i], costs, damages, i + 1, path)) return true;
                    path.remove(path.size()-1);
                }
                return false;
            }
        }
    }


    public static void main(String[] args) {
        DamageCardGame solu = new DamageCardGame();
        int totalDamage = 5;
        int totalMoney = 5;
        int[] costs = {5, 4, 1};
        int[] damages = {2, 3, 2};
        StdOut.println(solu.canCauseDamage(totalDamage, totalMoney, costs, damages));
    }
}
