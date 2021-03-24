package com.akiradunn.oj.leetcode.backtrack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//17. 电话号码的字母组合
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
//示例 1：
//
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//示例 2：
//
//输入：digits = ""
//输出：[]
//示例 3：
//
//输入：digits = "2"
//输出：["a","b","c"]
//
//
//提示：
//
//0 <= digits.length <= 4
//digits[i] 是范围 ['2', '9'] 的一个数字。
//通过次数239,867提交次数426,744
public class ALISolution17 {
    class Solution {
        List<String> res = new ArrayList<>();
        public List<String> letterCombinations(String digits) {
            if(digits.length() == 0) return res;
            Map<Character, String> map = new HashMap<>();
            map.put('2',"abc");
            map.put('3',"def");
            map.put('4',"ghi");
            map.put('5',"jkl");
            map.put('6',"mno");
            map.put('7',"pqrs");
            map.put('8',"tuv");
            map.put('9',"wxyz");
            StringBuilder builder = new StringBuilder();
            backFind(digits, builder, 0, map);
            return res;
        }

        /**
         * 回溯查找
         */
        public void backFind(String digits, StringBuilder builder, int index, Map<Character, String> map){
            if(index == digits.length()){
                res.add(builder.toString());
                return;
            }

            //输入信息
            char t = digits.charAt(index);
            //按键映射
            String keyMap = map.get(t);
            //回溯
            for(int i=0; i<keyMap.length(); i++){
                builder.append(keyMap.charAt(i));
                backFind(digits, builder, index+1, map);
                builder.deleteCharAt(builder.length()-1);
            }
        }
    }
}
