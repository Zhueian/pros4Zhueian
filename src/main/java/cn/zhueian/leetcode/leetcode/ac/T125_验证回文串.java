package cn.zhueian.leetcode.leetcode.ac;

/**
 * @Auther: qiucy
 * @Date: 2019-03-11 16:28
 * @Description:
 */
public class T125_验证回文串 {
    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     *
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * 示例 1:
     *
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     *
     * 输入: "race a car"
     * 输出: false
     */
    public static void main(String[] args) {
        new T125_验证回文串().isPalindrome("0P");
    }
    public boolean isPalindrome(String s) {
        System.out.println('a'-4);
        System.out.println('a'-'4');
        System.out.println('a'-'R');
        System.out.println('a'-' ');
        System.out.println('a'-'A');
        if(s.length()<2) return true;
        String letters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] chars = s.toCharArray();
        int length = chars.length;
        int right = length - 1,left = 0;
        while(right > left){
            while (right > left && !letters.contains(chars[right]+"")){
                right--;
            }
            while (right > left && !letters.contains(chars[left] + "")){
                left++;
            }
            int temp = Math.abs(chars[right] - chars[left]);
            if(chars[left] != chars[right]){
                if(!(temp == 32 && chars[right] > 57 && chars[left] >57)){
                    return false;
                }
            }
            right--;
            left++;
        }
        return true;
    }
    /**
     * best
     */


}
