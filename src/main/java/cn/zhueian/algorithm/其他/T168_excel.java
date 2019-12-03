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
    public String convertToTitle(int n) {
        String res = "";
        int shang = n/26;
        if (shang > 26){

        }
        int remainder = n%26;
        return res;
    }

    private static Instrumentation inst;
    public static void premain(String agentArgs,Instrumentation _inst){
        inst = _inst;
    }
    public static long sizeOf(Object o){
        return inst.getObjectSize(o);
    }

    public static void main(String[] args) {
        System.out.println("asd");
    }
}
