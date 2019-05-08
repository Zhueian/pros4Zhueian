package cn.zhueian.leetcode.leetcode.erro;

import java.util.*;

/**
 * @Auther: qiucy
 * @Date: 2018-12-27 20:36
 * @Description:给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class L5_longestPalindrome {
    public static void main(String[] args) {
        String s = "abcda";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }

    /**
     * 暴力法 超时了
     * @param s
     * @return
     */
    private static String longestPalindrome(String s){
        if(s != null && s.length()>2){
            Map<Integer,String> entry = new HashMap<>();
            List<Integer> length = new ArrayList<>();
            int count = 0;
            String[] split = s.split("");
            L1:for(int i = 0;i<split.length-1;i++){
                count = 0;
                for (int j = i+1;j<split.length;j++){
                    count++;
                    String substring = s.substring(i, j + 1);
                    String s1 = new StringBuffer(substring).reverse().toString();
                    if(s1.equals(substring)){
                        length.add(count);
                        entry.put(count,s1);
                    }
                }
            }
            Collections.sort(length, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(o1 > o2){
                        return -1;
                    } else if (o1 == o2) {
                        return 0;
                    } else{
                        return 1;
                    }
                }
            });
            if(length != null && length.size()>0){
                String reslut = entry.get(length.get(0));
                return reslut;
            }else{
                String[] k = s.split("");
                return k[0];
            }
        }else if(s.length() == 0){
            return "";
        }else if(s.length() == 1){
            return s;
        }else if(s.length() == 2){
            if(new StringBuffer(s).reverse().toString().equals(s)){
                return s;
            }else {
                String[] split = s.split("");
                return split[0];
            }
        } else{
            return null;
        }

    }
}

