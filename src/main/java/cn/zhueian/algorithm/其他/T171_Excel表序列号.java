package cn.zhueian.algorithm.其他;

/**
 * Created by qiucy on 2019/12/3.
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 例如，
 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 ...
 示例 1:
 输入: "A"
 输出: 1
 示例 2:
 输入: "AB"
 输出: 28
 示例 3:
 输入: "ZY"
 输出: 701
 */
public class T171_Excel表序列号 {
    public static int get(String in){
        in = new StringBuffer(in).reverse().toString();
        int res  = 0;
        int length = in.length();
        for (int i = 0; i < length; i++) {
            int t = 1;
            for (int j = 0; j < i; j++) t*=26;
            char c = in.charAt(i);
            int k = c-64;
            res+=k*t;
        }
        return res;
    }

    public static void main(String[] args) {
        //zy->701
//        System.out.println(26*26+25);
//        char a = 'A';
//        char b = 'B';
//        System.out.println(b-a);
//        System.out.println(a+0);
        int ab = get("AB");
        System.out.println(ab);
    }
}
