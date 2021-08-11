package com.codingpan.leetcode.passedOJ;

public class LC091DecodeWays {

    // version 1
    //	public int numDecodings(String s) {
    //	    if(s==null || s.length()==0 || s.charAt(0)=='0')
    //	    {
    //	        return 0;
    //	    }
    //	    int num1=1;
    //	    int num2=1;
    //	    int num3=1;
    //	    for(int i=1;i<s.length();i++)
    //	    {
    //	        if(s.charAt(i)=='0')
    //	        {
    //	            if(s.charAt(i-1)=='1' || s.charAt(i-1)=='2')
    //	                num3 = num1;
    //	            else
    //	                return 0;
    //	        }
    //	        else
    //	        {
    //	            if(s.charAt(i-1)=='0' || s.charAt(i-1)>='3')
    //	                num3 = num2;
    //	            else
    //	            {
    //	                if(s.charAt(i-1)=='2' && s.charAt(i)>='7' && s.charAt(i)<='9')
    //	                    num3 = num2;
    //	                else
    //	                    num3 = num1+num2;
    //	            }
    //	        }
    //	        num1 = num2;
    //	        num2 = num3;
    //	    }
    //	    return num2;
    //	}

    // version 2
    //	public int numDecodings(String s) {
    //	    //version 2
    //	    if (s == null || s.isEmpty() || s.charAt(0) == '0')	return 0;
    //
    //		int len = s.length();
    //		int[] ways = new int[len];
    //		ways[0] = 1;
    //
    //		for (int i = 1; i < len; i++) {
    //			int num = Integer.parseInt(s.substring(i-1, i+1));
    //			// 00
    //			if (num == 0) {
    //				ways[i] = 0;
    //			}
    //			if (num == 30 || num == 40 || num == 50 || num == 60 || num == 60 || num == 70
    //					|| num == 70 || num == 80 || num == 90) {
    //				return 0;
    //			}
    //			// 01 - 09, 27 - 99
    //			if ((num >= 1 && num <= 9) || (num >= 27 && num <= 99)) {
    //				ways[i] = ways[i-1];
    //			}
    //			// 10, 20
    //			if (num == 10 || num == 20) {
    //				if (i == 1) {
    //					ways[i] = ways[i-1];
    //				} else {
    //					ways[i] = ways[i-2];
    //				}
    //			}
    //			// 11 - 19, 21 - 26
    //			if ((num >= 11 && num <= 19) || (num >= 21 && num <= 26)) {
    //				if (i == 1) {
    //					ways[i] = ways[i-1] + 1;
    //				} else {
    //					ways[i] = ways[i-1] + ways[i-2];
    //				}
    //			}
    //		}
    //
    //		return ways[len-1];
    //    }

    // version 3
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;

        int len = s.length();
        int[] ways = new int[3];
        ways[0] = 1;
        ways[1] = 1;
        ways[2] = 1;

        for (int i = 1; i < len; i++) {
            int num = Integer.parseInt(s.substring(i - 1, i + 1));
            if (num == 30 || num == 40 || num == 50 || num == 60 || num == 60 || num == 70 || num == 70
                    || num == 80 || num == 90) {
                return 0;
            }

            // 00
            if (num == 0) {
                ways[2] = 0;
            }
            // 01 - 09, 27 - 99
            if ((num >= 1 && num <= 9) || (num >= 27 && num <= 99)) {
                ways[2] = ways[1];
            }
            // 10, 20
            if (num == 10 || num == 20) {
                ways[2] = ways[0];
            }
            // 11 - 19, 21 - 26
            if ((num >= 11 && num <= 19) || (num >= 21 && num <= 26)) {
                ways[2] = ways[1] + ways[0];
            }
            ways[0] = ways[1];
            ways[1] = ways[2];
        }

        return ways[2];
    }

    public static void main(String[] args) {
        LC091DecodeWays test = new LC091DecodeWays();
        String s1 = "230";
        String s2 = "1234";
        String s3 = "9999";
        System.out.println("expected(0) " + test.numDecodings(s1));
        System.out.println("expected(3) " + test.numDecodings(s2));
        System.out.println("expected(1) " + test.numDecodings(s3));
    }
}
