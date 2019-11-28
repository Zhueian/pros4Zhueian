package cn.zhueian.algorithm.其他;

/**
 * Created by qiucy on 2019/11/27.
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

 如果不存在最后一个单词，请返回 0 。

 说明：一个单词是指由字母组成，但不包含任何空格的字符串。

 示例:

 输入: "Hello World"
 输出: 5

 */
public class T58_最后一个单词长度 {
    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        if (split.length == 0)return 0;
        if (split.length<=1) return split[0].length();
        return split[split.length-1].length();
    }

    public static void main(String[] args) {
        String s = " asd ";
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }
}
