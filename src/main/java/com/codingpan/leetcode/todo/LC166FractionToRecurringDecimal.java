package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC166FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        return helper(numerator, denominator);
    }

    private String helper(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        long num = numerator, den = denominator;
        if (num * den == 0) return "0";
        if (num * den < 0) sb.append("-");
        Map<Long, Integer> map = new HashMap<>();
        num = Math.abs(num);
        den = Math.abs(den);
        sb.append(num / den);
        num %= den;
        if (num == 0) return sb.toString();
        sb.append(".");
        while (num != 0 && !map.containsKey(num)) {
            map.put(num, sb.length());
            sb.append(num * 10 / den);
            num = num * 10 % den;
        }
        if (num != 0) sb.insert(map.get(num), "(").append(")");
        return sb.toString();
    }

    private String myVersion(int numerator, int denominator) {
        if (denominator == 0) return "";
        StringBuilder sb0 = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        if (numerator > 0 && denominator < 0) {
            denominator = -denominator;
            sb0.append("-");
        }
        if (numerator < 0 && denominator > 0) {
            numerator = -numerator;
            sb0.append("-");
        }

        Set<Integer> set = new HashSet<Integer>();
        int quotient = numerator / denominator;
        int remainder = numerator % denominator;
        sb0.append(quotient);
        if (remainder != 0) sb0.append(".");
        String repeated = "";
        boolean repeatingZero = false;
        while (remainder != 0) {
            quotient = remainder * 10 / denominator;
            remainder = remainder * 10 % denominator;
            repeatingZero = quotient == 0;
            if (set.contains(quotient) && !repeatingZero) {
                repeated = String.valueOf(quotient);
                break;
            } else {
                set.add(quotient);
                sb.append(quotient > 0 ? quotient : -quotient);
            }
        }
        if (!repeated.isEmpty()) {
            sb.insert(sb.indexOf(repeated), "(");
            sb0.append(sb.toString());
            sb0.append(")");
        } else {
            sb0.append(sb.toString());
        }

        return new String(sb0);
    }

    public static void main(String[] args) {
        LC166FractionToRecurringDecimal solu = new LC166FractionToRecurringDecimal();
        int[] numerators = {1, 2, 2, 1, 8, -2, -9, 0, 0, 1, 1};
        int[] denominators = {2, 1, 3, 7, -2, 7, -3, -1, 1, 6, 333};
        for (int i = 0; i < numerators.length; i++) {
            String result = solu.fractionToDecimal(numerators[i], denominators[i]);
            StdOut.println(numerators[i] + "/" + denominators[i] + " = " + result);
        }
    }
}
