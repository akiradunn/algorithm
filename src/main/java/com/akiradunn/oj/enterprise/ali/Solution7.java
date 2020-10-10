package com.akiradunn.oj.enterprise.ali;

/**
 * 7-整数反转
 * @author duanzengliang
 * @since 2020/10/10 9:24
 */
public class Solution7 {

    /**
     *
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: 321
     *  示例 2:
     *
     * 输入: -123
     * 输出: -321
     * 示例 3:
     *
     * 输入: 120
     * 输出: 21
     * 注意:
     *
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2的31次方,  2的31次方 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     */


    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        System.out.println(solution7.reverse(1200));
    }


    public int reverse(int x) {
        boolean isNegative = x > 0 ? false : true;
        x = isNegative ? -x : x;
        String xStr = String.valueOf(x);
        StringBuffer buffer = new StringBuffer();
        //找到第一个不是0的索引
        int i = xStr.length()-1;
        while(i>=0 && xStr.charAt(i) == '0'){
            i--;
        }
        for(; i>=0 ; i--){
            buffer.append(xStr.charAt(i));
        }

        String retValueStr = buffer.toString();
        if(retValueStr.isEmpty()){
            return 0;
        }

        try{
            int result = isNegative ? -1 * Integer.parseInt(retValueStr) : Integer.parseInt(retValueStr);
            return result;
        //整数溢出直接返回0
        }catch (Exception e){
            return 0;
        }
    }
}
