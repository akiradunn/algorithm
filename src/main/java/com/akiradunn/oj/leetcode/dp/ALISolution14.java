package com.akiradunn.oj.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

//14. 最长公共前缀
//编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。
//
//
//
//示例 1：
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//示例 2：
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//提示：
//
//0 <= strs.length <= 200
//0 <= strs[i].length <= 200
//strs[i] 仅由小写英文字母组成
//通过次数475,420提交次数1,210,135
public class ALISolution14 {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if(strs.length == 0) return "";
            int len = Integer.MAX_VALUE;
            String minStr = "";
            for(int i=0; i<strs.length; i++){
                if(len > strs[i].length()){
                    len = strs[i].length();
                    minStr = strs[i];
                }
            }
            boolean[] f = new boolean[len+1];
            f[0] = true;
            int max = 0;
            for(int i=1; i<=len && f[i-1]; i++){
                char t = minStr.charAt(i-1);
                f[i] = true;
                for(int j=0; j<strs.length; j++){
                    if(t != strs[j].charAt(i-1)){
                        f[i] = false;
                        break;
                    }
                }
                f[i] = f[i-1] && f[i];
                max = f[i] ? i : max;
            }
            return max > 0 ? minStr.substring(0, max) : "";
        }
    }

    class Solution2 {
        public String longestCommonPrefix(String[] strs) {
            if(strs.length == 0) return "";
            if(strs.length == 1) return strs[0];
            List<char[]> list = new ArrayList<>();
            int minLen = strs[0].length();
            list.add(strs[0].toCharArray());
            int res = 0;
            for(int i=1; i<strs.length; i++){
                minLen = Math.min(minLen, strs[i].length());
                list.add(strs[i].toCharArray());
            }
            for(int i=0; i<minLen; i++){
                char firstChar = list.get(0)[i];
                int j=1;
                for(; j<list.size(); j++){
                    char tempChar = list.get(j)[i];
                    if(tempChar != firstChar){
                        break;
                    }
                }
                if(j != list.size()) break;
                res++;
            }
            return strs[0].substring(0, res);
        }
    }
}
