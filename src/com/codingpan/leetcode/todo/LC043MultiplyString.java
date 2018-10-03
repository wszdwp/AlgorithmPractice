package com.codingpan.leetcode.todo;

import edu.princeton.cs.algs4.StdOut;

public class LC043MultiplyString {
    //test
    public String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        String res = "";
        int count = 0;
        for (int i = num2.length()-1; i >= 0; i--) {
            sb = new StringBuilder();
            int product = 0;
            int carry = 0;
            int n2 = num2.charAt(i) - '0';

            for (int j = num1.length()-1; j >= 0; j--) {
                int n1 = num1.charAt(j) - '0';
                product = (n1 * n2 + carry) % 10;
                carry = (n1 * n2 + carry) / 10;
                sb.append(product);
            }
            if (carry != 0) sb.append(carry);
            if (!res.isEmpty()) {
                for (int c = 0; c < count; c++) sb.insert(0, '0');
                res = addString(res, sb.toString());
            } else {
                res = sb.toString();
            }
            count++;
        }
        return sb.reverse().toString();
    }

    private String addString(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int sum = 0;
        int carry = 0;
        while (i < num1.length() && i < num2.length()) {
            int temp = num1.charAt(i) + num2.charAt(i);
            sum += (temp + carry) / 10;
            carry = (temp + carry) % 10;
            sb.append(sum);
            i++;
        }
        sum = 0;
        while (i < num1.length()) {
            int temp = num1.charAt(i);
            sum += (temp + carry) / 10;
            carry = (temp + carry) % 10;
            sb.append(sum);
            i++;
        }
        sum = 0;
        while (i < num2.length()) {
            int temp = num2.charAt(i);
            sum += (temp + carry) / 10;
            carry = (temp + carry) % 10;
            sb.append(sum);
            i++;
        }
        if (carry != 0) sb.append(carry);
        return sb.toString();
    }

    public static long testRes(String n1, String n2) {
        return Long.valueOf(n1) * Long.valueOf(n2);
    }

    public static void main(String[] args) {
        LC043MultiplyString solu = new LC043MultiplyString();
        String n1 = "123";
        String n2 = "21";

        StdOut.println("expected " + testRes(n1, n2) + " " + solu.multiply(n1, n2));
    }
}
