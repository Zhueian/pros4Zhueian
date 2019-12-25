package cn.zhueian.struct.string;

/**
 * Created by qiucy on 2019/12/25.
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

 示例 1:

 输入: "Let's take LeetCode contest"
 输出: "s'teL ekat edoCteeL tsetnoc" 
 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。

 */
public class T557_反转字符串中的单词3 {
    public static String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuffer sbf = new StringBuffer();
        for(String ss:split){
            StringBuffer sb = new StringBuffer(ss);
            sb.reverse();
            sbf.append(sb.toString()+" ");
        }

        return sbf.substring(0,sbf.length()-1);
    }

    public static void main(String[] args) {

    }
}
