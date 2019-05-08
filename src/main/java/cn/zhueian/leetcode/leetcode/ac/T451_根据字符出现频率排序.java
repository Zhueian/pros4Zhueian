package cn.zhueian.leetcode.leetcode.ac;

import java.util.*;

/**
 * @Auther: qiucy
 * @Date: 2019-03-19 20:52
 * @Description:
 */
public class T451_根据字符出现频率排序 {
    /**
     *给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
     *
     * 示例 1:
     *
     * 输入:
     * "tree"
     *
     * 输出:
     * "eert"
     *
     * 解释:
     * 'e'出现两次，'r'和't'都只出现一次。
     * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
     * 示例 2:
     *
     * 输入:
     * "cccaaa"
     *
     * 输出:
     * "cccaaa"
     *
     * 解释:
     * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
     * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
     */
    public static void main(String[] args) {

    }
    public String frequencySort(String s) {
        if(s == null) return "";
        char[] chars = s.toCharArray();
        Map<Character,Integer> asd = new HashMap<>();
        for (char aChar : chars) {
            boolean b = asd.containsKey(aChar);
            if(b){
                Integer integer = asd.get(aChar);
                asd.put(aChar,++integer);
            }else{
                asd.put(aChar,1);
            }
        }
        List<Map.Entry<Character,Integer>> sdf = new ArrayList<>(asd.entrySet());
        Collections.sort(sdf, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        StringBuffer result = new StringBuffer("");
        for (Map.Entry<Character, Integer> characterIntegerEntry : sdf) {
            Integer times = characterIntegerEntry.getValue();
            Character key = characterIntegerEntry.getKey();
            for(int i = 0;i < times;i++){
                result.append(key);
            }
        }
        return result.toString();
    }

}
