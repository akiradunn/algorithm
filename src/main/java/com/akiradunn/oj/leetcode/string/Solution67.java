package com.akiradunn.oj.leetcode.string;
//67. 二进制求和
//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
//输入为 非空 字符串且只包含数字 1 和 0。
//
//
//
//示例 1:
//
//输入: a = "11", b = "1"
//输出: "100"
//示例 2:
//
//输入: a = "1010", b = "1011"
//输出: "10101"
//
//
//提示：
//
//每个字符串仅由字符 '0' 或 '1' 组成。
//1 <= a.length, b.length <= 10^4
//字符串如果不是 "0" ，就都不含前导零。
//通过次数173,519提交次数318,391
public class Solution67 {
    class Solution {
        public String addBinary(String a, String b) {
            char[] aCharArray = a.toCharArray();
            char[] bCharArray = b.toCharArray();
            int i = aCharArray.length-1;
            int j = bCharArray.length-1;
            int promote = 0;
            StringBuilder res = new StringBuilder();
            while(i>=0 && j>=0){
                int sum = (aCharArray[i]-'0') + (bCharArray[j]-'0') + promote;
                if(sum >= 2){
                    res.append(sum-2);
                    promote = 1;
                }else{
                    res.append(sum);
                    promote = 0;
                }
                i--;
                j--;
            }
            if(i >= 0){
                for(;i>=0;i--){
                    int sum  = (aCharArray[i]-'0') + promote;
                    if(sum >= 2){
                        res.append(sum-2);
                        promote = 1;
                    }else{
                        res.append(sum);
                        promote = 0;
                    }
                }
            }else if(j >= 0){
                for(;j>=0;j--){
                    int sum  = (bCharArray[j]-'0') + promote;
                    if(sum >= 2){
                        res.append(sum-2);
                        promote = 1;
                    }else{
                        res.append(sum);
                        promote = 0;
                    }
                }
            }
            if(promote > 0){
                res.append(promote);
            }
            return res.reverse().toString();
        }
    }
}
