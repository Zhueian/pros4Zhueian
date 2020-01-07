package cn.zhueian.algorithm.其他;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by qiucy on 2019/12/27.\
 * 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。

 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。

  

 示例 1：

 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
 输出：["girl","student"]
 示例 2：

 输入：text = "we will we will rock you", first = "we", second = "will"
 输出：["we","rock"]
  

 提示：

 1 <= text.length <= 1000
 text 由一些用空格分隔的单词组成，每个单词都由小写英文字母组成
 1 <= first.length, second.length <= 10
 first 和 second 由小写英文字母组成
 */
public class T1078_bigram分词 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> t = new ArrayList<>();
        int l = words.length;
        for (int i = 0; i < l-2; i++) {
            if (first.equals(words[i]) && second.equals(words[i+1])){
                t.add(words[i+2]);
            }
        }
        String[] ans = new String[t.size()];
        int l2 = ans.length;
        for (int i = 0; i < l2; i++) {
            ans[i] = t.get(i);
        }
        return ans;
    }
}
