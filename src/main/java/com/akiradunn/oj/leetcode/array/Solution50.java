package com.akiradunn.oj.leetcode.array;

public class Solution50 {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1/cal(x, -n);
        } else if (n > 0) {
            return cal(x, n);
        } else {
            return 1;
        }
    }
//
//    public double cal(double x, int n) {
//        double result = 1;
//        for (int i=0; i<n; i++) {
//            result *= x;
//        }
//        return result;
//    }

    /**
     * 二分与暴力的区别，可以将 On 复杂度转化为 Ologn
     * @param x
     * @param n
     * @return
     */
    public double cal(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double sub = cal(x, n/2);
        return n%2 == 0 ? sub * sub : sub * sub * x;
    }
}
