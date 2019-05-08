package cn.zhueian.leetcode.leetcode.ac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Auther: qiucy
 * @Date: 2018-12-27 19:32
 * @Description:
 */

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class L3_lengthOfLongestSubstring {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String a = "au";
        System.out.println(lengthOfLongestSubstring(a));

    }
    private static int lengthOfLongestSubstring(String s){
        if(s != null && s.length()>1){
            ArrayList<Integer> lGroup = new ArrayList<>();
            int flag = 0;
            int l = 0;
            String[] split = s.split("");
            L1:for (int i = 0;i<split.length-1;i++){
                l = 0;
                L2:for(int j = i+1;j<split.length;j++){
                    l++;
                    String substring = s.substring(i, j);
                    boolean contains = substring.contains(split[j]);
                    if(contains){
                        lGroup.add(l);
                        continue L1;
                    }
                }
                lGroup.add(l+1);
            }
            Collections.sort(lGroup, new Comparator<Integer>() {
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
            System.out.println(lGroup);
            if(lGroup != null && lGroup.size()>0){
                return lGroup.get(0);
            }else {
                return 0;
            }
        }else if(s != null && s.length() == 1){
            return 1;
        }else{
            return 0;
        }
    }
}

