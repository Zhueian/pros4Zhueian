package cn.zhueian.algorithm.其他;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qiucy on 2019/12/31.
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

 在 S 上反复执行重复项删除操作，直到无法继续删除。

 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

  

 示例：

 输入："abbaca"
 输出："ca"
 解释：
 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，
 其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
  

 提示：

 1 <= S.length <= 20000
 S 仅由小写英文字母组成。

 */
public class T1047_删除字符串中的所有相邻重复项 {
    //超时了
    public static String removeDuplicates(String S) {
        if (S == null || S.length()<2) return S;
        String[] split = S.split("");
        LinkedList<String> strings = new LinkedList<>();
        for (String s:split) strings.add(s);
        for (int i = 0; i < strings.size()-1; i++) {
            String s1 = strings.get(i);
            String s2 = strings.get(i+1);
            if (s1.equals(s2)){
                strings.remove(i);
                strings.remove(i);
                i = -1;
            }
        }
        StringBuffer sbf = new StringBuffer();
        for (String s:strings) sbf.append(s);
        return sbf.toString();
    }

    public static void main(String[] args) {
        removeDuplicates("abbaca");
    }
    //双指针
    public String removeDuplicates2(String S){
        if (S == null || S.length()<2) return S;
        char[]  ans = new char[S.length()];
        int i = 0;
        int j = 0;
        int length = S.length();
        for (int k = 0; k < length; k++) {

        }
        return String.valueOf(ans).substring(0,1);
    }
}
