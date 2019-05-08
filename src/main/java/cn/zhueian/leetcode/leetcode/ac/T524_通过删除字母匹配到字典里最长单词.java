package cn.zhueian.leetcode.leetcode.ac;

import java.util.*;

/**
 * @Auther: qiucy
 * @Date: 2019-03-12 22:20
 * @Description:
 */
public class T524_通过删除字母匹配到字典里最长单词 {
    /**
     * 给定一个字符串和一个字符串字典，
     * 找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
     * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
     * 示例 1:
     *
     * 输入:
     * s = "abpcplea", d = ["ale","apple","monkey","plea"]
     *
     * 输出:
     * "apple"
     * 示例 2:
     *
     * 输入:
     * s = "abpcplea", d = ["a","b","c"]
     *
     * 输出:
     * "a"
     * 说明:
     *
     * 所有输入的字符串只包含小写字母。
     * 字典的大小不会超过 1000。
     * 所有输入的字符串长度不会超过 1000。
     */
    public String findLongestWord(String s, List<String> d) {
        List<String> results = new ArrayList<>();
        results.add("");
        int dictionaryItemPointer = 0,strIndex = 0,strLength = s.length();
        for (int i = 0; i < d.size(); i++) {
            String item = d.get(i);
            b:for(int j = 0;j < item.length() && strIndex < strLength;j++){
                int k = strIndex;
                a:for(;k < strLength;k++){
                    if(item.charAt(j) == s.charAt(k)){
                        strIndex = ++k;
                        if(j == item.length()-1){
                            results.add(item);
                        }
                        continue b;
                    }else{
                        strIndex++;
                        continue a;
                    }
                }
            }
            strIndex = 0;
        }
        Collections.sort(results, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()){
                    return o2.length() - o1.length();
                }else {
                    return o1.compareTo(o2);
                }
            }
        });
        return results.get(0);
    }
    public static void main(String[] args) {
        new T524_通过删除字母匹配到字典里最长单词().findLongestWord("abpcplea",Arrays.asList("ale","apple","monkey","plea","abple"));
    }
    /**
     * best,以空间换时间，不好啊！！
     */
    public String findLongestWord2(String s, List<String> d) {
        Collections.sort(d, (a,b) -> a.length() != b.length() ? -Integer.compare(a.length(), b.length()) :  a.compareTo(b));
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray())
                if (i < dictWord.length() && c == dictWord.charAt(i)) i++;
            if (i == dictWord.length()) return dictWord;
        }
        return "";
    }
}
