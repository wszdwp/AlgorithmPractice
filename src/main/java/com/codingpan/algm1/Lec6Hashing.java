package com.codingpan.algm1;

import edu.princeton.cs.algs4.StdOut;

import static java.lang.Double.doubleToLongBits;

public class Lec6Hashing {
    // return 32 bit int
    // default impl is the memory address of x
    // always return 17 legal but poor
    // customized impl
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {
        long bits = doubleToLongBits(1.2);
        StdOut.println(bits);
        long lobits = bits >>> 32;
        StdOut.println(Long.toBinaryString(bits));
        StdOut.println(Long.toBinaryString(lobits));
        StdOut.println(Long.toBinaryString((int) bits ^ lobits));
    }
}
