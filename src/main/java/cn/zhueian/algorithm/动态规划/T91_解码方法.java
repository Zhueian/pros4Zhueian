package cn.zhueian.algorithm.动态规划;

import java.util.stream.Stream;

/**
 * Created by qiucy on 2019/12/27.
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 给定一个只包含数字的非空字符串，请计算解码方法的总数。

 示例 1:

 输入: "12"
 输出: 2
 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 示例 2:

 输入: "226"
 输出: 3
 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class T91_解码方法 {
    public int numDecodings(String s) {
        if (s.startsWith("0")) return 0;
        int length = s.length();
        int[] currToIndex = new int[length];
        System.out.println(s);
        for (int i = 0; i < length; i++) {
            if (i == 0) currToIndex[i] = 1;
            if (i >= 1) {
                if(s.substring(i-1,i+1).equals("00")) return 0;
                else if (s.substring(i-1,i+1).contains("0")) currToIndex[i] = currToIndex[i-1];
                else if (Integer.parseInt(s.substring(i-1,i+1))<=26) currToIndex[i] = currToIndex[i-1]+1;
                else currToIndex[i] = currToIndex[i-1];
            }
        }
        return currToIndex[length-1];
    }

    public static void main(String[] args) {
        System.out.println("123534".substring(0,2));

    }
}
