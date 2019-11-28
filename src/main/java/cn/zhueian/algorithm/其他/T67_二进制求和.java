package cn.zhueian.algorithm.其他;

/**
 * Created by qiucy on 2019/11/27.
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。

 输入为非空字符串且只包含数字 1 和 0。

 示例 1:

 输入: a = "11", b = "1"
 输出: "100"
 示例 2:

 输入: a = "1010", b = "1011"
 输出: "10101"
 */
public class T67_二进制求和 {
    public static String addBinary(String a, String b) {
        a = new StringBuffer(a).reverse().toString();
        b = new StringBuffer(b).reverse().toString();
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        char[] s ;
        char[] l ;
        if (aa.length>bb.length){
            l = aa;
            s = bb;
        }else{
            l = bb;
            s = aa;
        }
        int in = 48;
        for (int i = 0; i < l.length; i++) {
            int var1 = 48;
            if (s.length>i){
                var1 = s[i];
            }
            char var2 = l[i];
            int next = var1+var2+in;
            if (next == 147){
                stringBuffer.append("1");
                in = 49;
            }
            if (next == 144){
                stringBuffer.append("0");
                in = 48;
            }
            if (next == 146){
                stringBuffer.append("0");
                in = 49;
            }
            if (next == 145){
                stringBuffer.append("1");
                in = 48;
            }
            if (i == l.length-1){
                if (in == 49){
                    stringBuffer.append("1");
                }
            }
        }
        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {
        char[] chars = "1101".toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int a = Integer.parseInt(chars[i]+"");
            int b = chars[i];
            System.out.println(a+"``"+b);
        }
    }
}
