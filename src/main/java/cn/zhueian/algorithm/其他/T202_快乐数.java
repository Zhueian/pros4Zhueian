package cn.zhueian.algorithm.其他;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by qiucy on 2019/12/4.
 * 编写一个算法来判断一个数是不是“快乐数”。

 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。

 示例: 

 输入: 19
 输出: true
 解释:
 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1
 */
public class T202_快乐数 {
    public static boolean isHappy(int n) {
        Set<Integer> looper = new HashSet<>();
        int sum = n;
        while (looper.add(sum)){
            String s = sum+"";
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                res+=(Integer.parseInt(s.charAt(i)+"")*Integer.parseInt(s.charAt(i)+""));
            }
            sum = res;
            if (sum == 1) return true;
        }
        return false;
    }

    private boolean m(int n) {
        String s = n+"";
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res+=(Integer.parseInt(s.charAt(i)+"")*Integer.parseInt(s.charAt(i)+""));
        }
        return res == 1;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
