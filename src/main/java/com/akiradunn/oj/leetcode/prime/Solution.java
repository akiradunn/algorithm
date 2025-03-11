package com.akiradunn.oj.leetcode.prime;

public class Solution {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    public static int countPrimes(int n) {
        int result = 1;
        for(int i=1; i<n; i++) {
            if (checkIfPrime(n)) {
                result ++;
            }
        }

        return result;
    }

    private static boolean checkIfPrime(int n) {
        if (n <= 3) {
            return n > 1;
        }

        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }
}
