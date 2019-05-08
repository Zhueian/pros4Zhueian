package cn.zhueian.leetcode.leetcode.ac;
import java.util.HashSet;

/**
 * @Auther: qiucy
 * @Date: 2019-03-08 14:56
 * @Description:
 */
public class T409_最长回文串 {
    /**
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     *
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     *
     * 注意:
     * 假设字符串的长度不会超过 1010。
     *
     * 示例 1:
     *
     * 输入:
     * "abccccdd"
     *
     * 输出:
     * 7
     *
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     */
    public static void main(String[] args) {

    }
    public int longestPalindrome(String s) {
        if (s.length() == 0) return 0;
        HashSet<Character> cnt = new HashSet<>();
        char[] letters = s.toCharArray();
        int length = 0;
        for (char letter : letters) {
            if (!cnt.contains(letter)){
                cnt.add(letter);
            }else{
                cnt.remove(letter);
                length++;
            }

        }
        if(cnt.isEmpty()) return length*2;
        return length*2+1;
    }

}
