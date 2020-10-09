package com.akiradunn.oj.enterprise.ali;

/**
 * 5. 最长回文子串
 * @author duanzengliang
 * @since 2020/10/9 13:59
 */
public class Solution5 {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * 中心扩展算法
     * 1.思考是否可以用dp,发现子问题的结果并没有跟当前问题有强烈相关,当前问题的结果并不能直接由子问题推导出来,故不能用dp(错误,dp是如果可以定义迭代方程就可以用)
     * 2.从问题本身出发,最长回文子串,可以考虑从每一个字符开始想象搜索最长的回文子串是哪个,得来思路
     */
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
//        String test = "babad";
        String test = "cbbd";
        System.out.println(solution5.longestPalindrome(test));
    }

    public String longestPalindrome(String s) {
        if(s == null || s.isEmpty()){
            return "";
        }

        if(s.length() == 1){
            return s;
        }

        String tempStr= s;
        String longestStr = "";
        for(int i=0;i<s.length();i++){
            String cycleStr = checkStrIsCycle(s,i);
            if(!cycleStr.isEmpty()){
                longestStr = cycleStr.length() > longestStr.length() ? cycleStr : longestStr;
            }
        }
        return longestStr;
    }

    public String checkStrIsCycle(String str, int i){
        String cycleStr = str.charAt(i)+"";
        int left = i;
        int right = i+1;
        //第i个字符和第i+1个字符相等
        while(left >= 0 && right <= str.length()-1){
            if(str.charAt(left) != str.charAt(right)){
                break;
            }
            String substring = str.substring(left, right + 1);
            cycleStr = substring.length() > cycleStr.length() ? substring : cycleStr;
            left --;
            right ++;
        }

        //第i个字符和第i+1个字符不相等
        left = i-1;
        right = i+1;
        while(left >= 0 && right <= str.length()-1){
            if(str.charAt(left) != str.charAt(right)){
                break;
            }
            String substring = str.substring(left, right + 1);
            cycleStr = substring.length() > cycleStr.length() ? substring : cycleStr;
            left --;
            right ++;
        }
        return cycleStr;
    }


    /**
     * 官方题解
     * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
     */
    public String longestPalindromeByLeetCode(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }
}
