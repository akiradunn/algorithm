package com.akiradunn.oj.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE / 2);
        System.out.println(new Solution().reverseWords(" the sky is blue"));
    }

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
