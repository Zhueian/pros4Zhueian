package cn.zhueian.leetcode.leetcode.ac;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: qiucy
 * @Date: 2019-03-10 19:06
 * @Description:
 */
public class T345_反转字符串中的元音字母 {
    /**
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     *
     * 示例 1:
     *
     * 输入: "hello"
     * 输出: "holle"
     * 示例 2:
     *
     * 输入: "leetcode"
     * 输出: "leotcede"
     * 说明:
     * 元音字母不包含字母"y"。
     *
     * aeiou
     */
    public static void main(String[] args) {

    }

    /**
     *
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length-1;
        while(left < right){
            while(left < right && !vowels.contains(chars[left]+"")){
                left ++;
            }
            while(left < right && !vowels.contains(chars[right]+"")){
                right --;
            }
            char swapTemp = chars[left];
            chars[left] = chars[right];
            chars[right] = swapTemp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
