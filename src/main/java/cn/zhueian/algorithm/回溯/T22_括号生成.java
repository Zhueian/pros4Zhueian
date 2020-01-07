package cn.zhueian.algorithm.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qiucy on 2020/1/7.
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

 例如，给出 n = 3，生成结果为：

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 n = 1
 [
 "()"
 ]
 n = 2
 [
 "()()",
 "(())"
 ]

 */
public class T22_括号生成 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));

    }

    private static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        help("",ans,n,0,0);
        return ans;
    }

    private static void help(String subS,List<String> ans, int max, int left, int right) {
        if (max*2 == subS.length()) ans.add(subS);
        if (left<max) help(subS+"(",ans,max,left+1,right);
        if (right<left) help(subS+")",ans,max,left,right+1);
    }
}
