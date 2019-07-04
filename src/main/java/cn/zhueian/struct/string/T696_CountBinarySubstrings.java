package cn.zhueian.struct.string;

import java.util.HashMap;

/**
 * @Auther: qiucy
 * @Date: 2019-07-02 14:17
 * @Description:
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是
 * 组合在一起的。
 * 重复出现的子串要计算它们出现的次数。
 * 示例 1 :
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * 示例 2 :
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 */
public class T696_CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        if (s == null) return 0;
        int l = s.length(),r = 0;
        if (l < 2) return 0;
        for (int i = 0;i < l-1;i++) r+=get(s.substring(i,l));
        return r;
    }

    private int get(String substring) {
        int l = substring.length();
        for (int i = 0; i < l; i++) {

        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "00110011";
        System.out.println(s.substring(0,s.length()));
    }
}
