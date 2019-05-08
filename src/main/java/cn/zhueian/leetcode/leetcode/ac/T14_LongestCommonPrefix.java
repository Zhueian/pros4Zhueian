package cn.zhueian.leetcode.leetcode.ac;

/**
 * @Auther: qiucy
 * @Date: 2019-04-29 18:33
 * @Description:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */
public class T14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)   return "";
        if (strs.length == 1) return strs[0];
        int count = 0;
        a:while(true){
            if (strs[0].length() > count){
                Character temp = strs[0].charAt(count);
                for (int i = 1; i < strs.length; i++) {
                    if (strs[i].length() > count){
                        if(strs[i].charAt(count) != temp){
                        }
                    }else{
                        if (count == 0) return "";
                        break a;
                    }
                }
                count++;
            }else {
                if (count == 0) return "";
                break a;
            }

        }
        return strs[0].substring(0,count);
    }
    public static void main(String[] args) {
//        String test = "qweasd";
//        System.out.println(test.substring(0,3));
        String[] strs = {"c","c"};
//        String[] strs = {"flower","flow","flight"};
        new T14_LongestCommonPrefix().longestCommonPrefix(strs);
    }
}
