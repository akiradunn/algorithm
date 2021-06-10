package com.akiradunn.oj.leetcode.array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//66. 加一
//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
//最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
//你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//
//
//示例 1：
//
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
//示例 2：
//
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
//示例 3：
//
//输入：digits = [0]
//输出：[1]
//
//
//提示：
//
//1 <= digits.length <= 100
//0 <= digits[i] <= 9
//通过次数300,790提交次数657,033
public class Solution66 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] plusOne(int[] digits) {
            if(digits[0] == 0) return new int[]{1};
            int n = digits.length;
            List<Integer> res = new ArrayList<>();
            int lastPromote = 1;
            for(int i=n-1; i>=0; i--){
                int t = digits[i] + lastPromote;
                if(t >= 10){
                    res.add(t-10);
                    lastPromote = t - 9;
                }else{
                    res.add(t);
                    lastPromote = 0;
                }
                if(i == 0 && lastPromote > 0){
                    res.add(lastPromote);
                }
            }
            Collections.reverse(res);
            return res.stream().mapToInt(i -> i.intValue()).toArray();
        }
    }
}
