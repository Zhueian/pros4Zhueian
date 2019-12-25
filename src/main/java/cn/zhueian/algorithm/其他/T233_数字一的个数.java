package cn.zhueian.algorithm.其他;

/**
 * Created by qiucy on 2019/12/10.
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。

 示例:

 输入: 13
 输出: 6
 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 */
public class T233_数字一的个数 {

    //timeout
    public static int countDigitOne(int n) {
        int res = 0;
        int t = n;
        while (n>0){
            while (t>0){
                if (t%10!=0) res++;
                t/=10;
            }
            n--;
            t = n;
        }
        return res;
    }
    public static int countDigitOne2(int n) {
        int res = 0;
        for (int i = n;i>0;i--){
            String s = String.valueOf(i);
            int length = s.length();
            for (int j = 0; j < length; j++) if (s.charAt(j)-1 == 48) res++;

        }
        return res;
    }

    public static void main(String[] args) {
        String s = "q01";
        System.out.println(s.charAt(1)-0);
        System.out.println(countDigitOne(13));
        System.out.println(countDigitOne2(13));
    }
}
