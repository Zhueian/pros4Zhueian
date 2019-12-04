package cn.zhueian.algorithm.其他;

import java.lang.instrument.Instrumentation;

/**
 * Created by qiucy on 2019/12/2.
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。

 例如，

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 ...
 示例 1:

 输入: 1
 输出: "A"
 示例 2:

 输入: 28
 输出: "AB"
 示例 3:

 输入: 701
 输出: "ZY"
 */
public class T168_excel {
    //十进制-》二十六进制
    public static String convertToTitle(int n) {
        if (n <= 26) {
            char a = (char) (0+n+64);
            return a+"";
        }
        if (n < 1) return "";
        StringBuffer sbf = new StringBuffer("");
        int shang = n;
        while (shang > 0){
            int remainder = shang%26;
            if(remainder == 0){
                remainder = 26;
            }
            char a = (char) (0+remainder+64);
            sbf.append(a+"");
            shang = shang/26;
//            if (shang == 1) break;;
        }
        return sbf.reverse().toString();
    }

    public String convertToTitle2(int n){
        return  n == 0 ? "" : convertToTitle2(--n/26)+(char)('A'+(n-1)%26);
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(26));
        int j = 65;
        char a = (char) j;
        System.out.println(a);

        System.out.println(26*26);
    }
    //获取Object 大小
    private static Instrumentation inst;
    public static void premain(String agentArgs,Instrumentation _inst){
        inst = _inst;
    }
    public static long sizeOf(Object o){
        return inst.getObjectSize(o);
    }
}
