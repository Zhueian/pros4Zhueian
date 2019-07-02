package cn.zhueian.struct.string;

import java.util.HashMap;

/**
 * @Auther: qiucy
 * @Date: 2019-07-01 14:39
 * @Description:
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * 示例 1:
 * 输入: s = "egg", t = "add"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "foo", t = "bar"
 * 输出: false
 *
 * 示例 3:
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 */
public class T205_同构字符串 {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() < 2 && t.length() < 2) return true;
        HashMap<Character,Integer> toS = new HashMap<>();
        HashMap<Character,Integer> toT = new HashMap<>();
        System.out.println(s.charAt(0)+1);
        System.out.println(s.charAt(0)+256);
        StringBuffer sbs = new StringBuffer("");
        StringBuffer sbt = new StringBuffer("");
        int l = s.length();
        for (int i = 0;i<l;i++) {
            boolean has = toS.containsKey(s.charAt(i));
            if (!has) toS.put(s.charAt(i),i);
            else sbs.append(toS.get(s.charAt(i))+"");
        }
        for (int i = 0;i<l;i++) {
            boolean has = toT.containsKey(t.charAt(i));
            if (!has) toT.put(t.charAt(i),i);
            else sbt.append(toT.get(t.charAt(i))+"");
        }
        return sbs.toString().equals(sbt.toString());
    }

    public static void main(String[] args) {
//        boolean isomorphic = isIsomorphic("aba", "baa");
//        boolean isomorphic2 = isIsomorphic("egg", "add");
//        boolean isomorphic3 = isIsomorphic("ab", "ab");
//        System.out.println(isomorphic2);
        int[] m = new int[512];
        m[0] = m[9] = 99;
        System.out.println(m[0]);
        System.out.println(m[9]);
    }
}
