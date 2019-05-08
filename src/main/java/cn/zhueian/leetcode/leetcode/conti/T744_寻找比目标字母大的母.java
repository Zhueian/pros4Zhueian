package cn.zhueian.leetcode.leetcode.conti;

import java.util.Arrays;

/**
 * @Auther: qiucy
 * @Date: 2019-03-25 22:22
 * @Description:
 */
public class T744_寻找比目标字母大的母 {
    /**
     * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，
     * 寻找有序数组里面比目标字母大的最小字母。
     *
     * 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z'
     * 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
     *
     * 示例:
     *
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "a"
     * 输出: "c"
     *
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "c"
     * 输出: "f"
     *
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "d"
     * 输出: "f"
     *
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "g"
     * 输出: "j"
     *
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "j"
     * 输出: "c"
     *
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "k"
     * 输出: "c"
     * 注:
     *
     * letters长度范围在[2, 10000]区间内。
     * letters 仅由小写字母组成，最少包含两个不同的字母。
     * 目标字母target 是一个小写字母。
     */
    public static void main(String[] args) {
        System.out.println(5/2);
        char[] a = {'c', 'f', 'j'};
        new T744_寻找比目标字母大的母().nextGreatestLetter2(a,'g');
    }

    /**
     * best
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int left = 0,right = n;
        while(left < right){
            int mid = left + (right - left)/2;
            if (letters[mid] > target)  right = mid;
            else left = mid + 1;
        }
        return letters[left % n];
    }
    /**
     * best2
     */
    public char nextGreatestLetter2(char[] letters, char target){
        // letters = ["c", "f", "j"]
        //     * target = "g"
        //     * 输出: "j"
        int n = letters.length;
        if (target >= letters[n - 1]) target = letters[0];
        else target++;

        int left = 0,right = n - 1;
        while (right > left){
            int mid = left + (right - left)/2;
            if (letters[mid] == target) return  letters[mid];
            if (letters[mid] < target) left = mid + 1;
            else right = mid;
        }
        return letters[right];
    }
    /**
     * 最简单粗暴
     */
    public char nextGreatestLetter3(char[] letters, char target){
        for (char letter : letters) {
            if(letter > target){
                return letter;
            }
        }
        return letters[0];
    }
    /**
     * best3
     */
    public char nextGreatestLetter4(char[] letters, char target) {
        int i = Arrays.binarySearch(letters, (char) (target + 1));
        return letters[i >= 0 ? i : ~i % letters.length];
    }
}
