package cn.zhueian.leetcode.leetcode.ac;

import java.util.*;

/**
 * @Auther: qiucy
 * @Date: 2019-03-14 10:08
 * @Description:
 */
public class T347_前K个高频元素 {
    /**
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     *
     * 示例 1:
     *
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     *
     * 输入: nums = [1], k = 1
     * 输出: [1]
     * 说明：
     *
     * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小
     */
    public static void main(String[] args) {
        System.out.println("sadad");
        int[] a = {1,2,3,};
        new T347_前K个高频元素().topKFrequent(a,2);
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums.length == 0) return null;
        List<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> compator = new HashMap<>();
        for (int num : nums) {
            boolean b = compator.containsKey(num);
            if(b){
                Integer value = compator.get(num);
                compator.put(num,++value);
            }else {
                compator.put(num,1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = compator.entrySet();
        List<Map.Entry<Integer, Integer>> asd = new ArrayList<>(entries);
        Collections.sort(asd, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        for(int i = 0;i < k;i++){
            result.add(asd.get(i).getKey());
        }
        return result;
    }
}
