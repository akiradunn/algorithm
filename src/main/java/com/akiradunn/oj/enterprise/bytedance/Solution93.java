package com.akiradunn.oj.enterprise.bytedance;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//93. 复原 IP 地址
//给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
//
//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
//例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
//
//
//
//示例 1：
//
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
//示例 2：
//
//输入：s = "0000"
//输出：["0.0.0.0"]
//示例 3：
//
//输入：s = "1111"
//输出：["1.1.1.1"]
//示例 4：
//
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
//示例 5：
//
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
//
//
//提示：
//
//0 <= s.length <= 3000
//s 仅由数字组成
//通过次数116,131提交次数221,005
public class Solution93 {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();
        char[] chars = "test".toCharArray();
        System.out.println(new String(chars, 0, 1));
    }

    class Solution {
        List<String> res = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            if(s.length() == 0 || s.length() <4 || s.length() >12) return res;
            char[] charArray = s.toCharArray();
            Deque<String> path = new ArrayDeque<>();
            dfs(charArray, charArray.length, 0, 0, path);
            return res;
        }

        public void dfs(char[] charArray, int len, int splitTimes, int l, Deque<String> path){
            if(l == len){
                if(splitTimes == 4){
                    res.add(String.join(".", path));
                }
                return;
            }

            if(len-l < (4-splitTimes) || len-l > 3*(4-splitTimes)){
                return;
            }

            for(int i=0; i<3; i++){
                if (l+i >= len) {
                    break;
                }

                int ipSeg = ipSegment(charArray, l, l+i);
                if(ipSeg != -1){
                    path.addLast(String.valueOf(ipSeg));
                    dfs(charArray, len, splitTimes+1, l+i+1, path);
                    path.pollLast();
                }
            }
        }

        public int ipSegment(char[] charArray, int l, int r){
            int len = r - l + 1;

            // 大于 1 位的时候，不能以 0 开头
            if (len > 1 && charArray[l] == '0') {
                return -1;
            }

            // 转成 int 类型
            int res = 0;
            for (int i = l; i <= r; i++) {
                res = res * 10 + charArray[i] - '0';
            }

            if (res > 255) {
                return -1;
            }
            return res;
        }
    }
}