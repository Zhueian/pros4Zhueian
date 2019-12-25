package cn.zhueian.algorithm.其他;

/**
 * Created by qiucy on 2019/12/23.
 */
public class T461_汉明距离 {
    public int hammingDistance(int x, int y) {
        int res = 0;

        String s1 = Integer.toBinaryString(x);
        String s2 = Integer.toBinaryString(y);
        int l1 = s1.length();
        int l2 = s2.length();

        if (l2 > l1) {

        }
        for (int i = 0; i < Math.max(s1.length(),s2.length()); i++) {
            if (i >= Math.min(s1.length(),s2.length())-1){

            }else {

            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(999));
    }
    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
