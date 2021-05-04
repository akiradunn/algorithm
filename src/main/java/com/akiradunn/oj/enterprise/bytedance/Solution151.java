package com.akiradunn.oj.enterprise.bytedance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//151. 翻转字符串里的单词
//给定一个字符串，逐个翻转字符串中的每个单词。
//
//说明：
//
//无空格字符构成一个 单词 。
//输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//
//
//示例 1：
//
//输入："the sky is blue"
//输出："blue is sky the"
//示例 2：
//
//输入："  hello world!  "
//输出："world! hello"
//解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//示例 3：
//
//输入："a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//示例 4：
//
//输入：s = "  Bob    Loves  Alice   "
//输出："Alice Loves Bob"
//示例 5：
//
//输入：s = "Alice does not even like bob"
//输出："bob like even not does Alice"
//
//
//提示：
//
//1 <= s.length <= 104
//s 包含英文大小写字母、数字和空格 ' '
//s 中 至少存在一个 单词
//
//
//进阶：
//
//请尝试使用 O(1) 额外空间复杂度的原地解法。
//通过次数134,302提交次数287,684
public class Solution151 {
    static class Solution{
        public String reverseWords(String s){
            int n = s.length();
            char[] charArray = s.toCharArray();
            int move = n-1;
            for(int i=n-1; i>=0; i--){
                if(charArray[i] == ' '){
                    continue;
                }
                int j = i;
                for(;j>=0;){
                    if(charArray[j] != ' '){
                        charArray[move--] = charArray[j--];
                    }else{
                        charArray[move--] = ' ';
                        break;
                    }
                }
                i = j;
            }

            move = move < 0 ? (charArray[0] == ' ' ? 1 : 0) : (charArray[move] == ' ' ? move+1 : move);
            String s1 = new String(charArray, move, n - move);
            String[] s2 = s1.split(" ");
            List<String> res = new ArrayList<>();
            for (String s3 : s2) {
                res.add(s3);
            }
            Collections.reverse(res);
            StringBuilder builder = new StringBuilder();
            for (String re : res) {
                builder.append(re).append(" ");
            }
            builder.deleteCharAt(builder.length()-1);
            return builder.toString();
        }
    }
}
