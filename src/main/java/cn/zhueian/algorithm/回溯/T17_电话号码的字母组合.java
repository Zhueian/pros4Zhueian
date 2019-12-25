package cn.zhueian.algorithm.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qiucy on 2019/12/11.
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



 示例:

 输入："23"
 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 说明:
 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class T17_电话号码的字母组合 {
    //用for解决
    public static List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) return res;
        res.add("");
        int length = digits.length();
        for (int i = 0; i < length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                //2->abc
                String combo = get(digits.charAt(i)+"");
                int comL = combo.length();
                for (int k = 0; k < comL; k++)
                    res.add(res.get(j)+combo.charAt(k));

            }
            for (int j = 0; j < size; j++)
                res.remove(0);
        }
        return res;
    }
    private static String get(String in){
        switch (in){
            case "2":return "abc";
            case "3":return "def";
            case "4":return "ghi";
            case "5":return "jkl";
            case "6":return "mno";
            case "7":return "pqrs";
            case "8":return "tuv";
            case "9":return "wxyz";
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
