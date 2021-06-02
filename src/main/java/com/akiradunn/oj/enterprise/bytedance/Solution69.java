package com.akiradunn.oj.enterprise.bytedance;
//69. x 的平方根
//实现 int sqrt(int x) 函数。
//
//计算并返回 x 的平方根，其中 x 是非负整数。
//
//由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
//示例 1:
//
//输入: 4
//输出: 2
//示例 2:
//
//输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842...,
//     由于返回类型是整数，小数部分将被舍去。
//通过次数317,722提交次数809,433
public class Solution69 {
    class Solution {
        public int mySqrt(int x) {
            if(x <= 1) return x;
            //long * long 才是 long, int * int 会有整型溢出成为负数的bug
            for(long i=1; i<=x; i++){
                long val = i * i;
                if(val > x){
                    return Integer.valueOf(String.valueOf(i-1));
                }
            }
            return -1;
        }
    }
}
