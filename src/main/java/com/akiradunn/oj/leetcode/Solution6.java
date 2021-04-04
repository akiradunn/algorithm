package com.akiradunn.oj.leetcode;

import java.util.ArrayList;
import java.util.List;
//6. Z 字形变换
//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
//
//比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
//
//请你实现这个将字符串进行指定行数变换的函数：
//
//string convert(string s, int numRows);
//
//
//示例 1：
//
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
//示例 2：
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
//示例 3：
//
//输入：s = "A", numRows = 1
//输出："A"
//
//
//提示：
//
//1 <= s.length <= 1000
//s 由英文字母（小写和大写）、',' 和 '.' 组成
//1 <= numRows <= 1000
//通过次数235,590提交次数472,546
public class Solution6 {
    class Solution {
        public String convert(String s, int numRows) {
            //模拟题目遍历字符串, 每行用一个单独的StringBuilder存储结果, 将属于某行的字符追加进对应行的StringBuilder
            if(numRows == 1) return s;
            List<StringBuilder> res = new ArrayList<>();
            for(int i=0; i<numRows; i++){
                res.add(new StringBuilder());
            }

            int curRow = 0;
            int flag = -1;
            for(int i=0; i<s.length(); i++){
                StringBuilder builder = res.get(curRow);
                builder.append(s.charAt(i));
                if(curRow == numRows-1 || curRow == 0){
                    flag = -flag;
                }
                curRow += flag;
            }

            StringBuilder builder = new StringBuilder();
            for(int i=0; i<numRows; i++){
                builder.append(res.get(i));
            }
            return builder.toString();
        }
    }
}
