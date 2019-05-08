package cn.zhueian.leetcode.leetcode.ac;

import java.util.*;

/**
 * @Auther: qiucy
 * @Date: 2019-03-19 21:11
 * @Description:
 */
public class T75_颜色分类 {
    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     *
     * 注意:
     * 不能使用代码库中的排序函数来解决这道题。
     *
     * 示例:
     *
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     * 进阶：
     *
     * 一个直观的解决方案是使用计数排序的两趟扫描算法。
     * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
     * 你能想出一个仅使用常数空间的一趟扫描算法吗？
     */
    public static void main(String[] args) {
        int [] a = {1,1,0};
        new T75_颜色分类().sortColors(a);
    }
    public void sortColors(int[] nums) {
        HashMap<Integer,Integer> sad = new HashMap<>();
        for (int num : nums) {
            sad.put(num,sad.getOrDefault(num,0)+1);
        }
        List<Map.Entry<Integer,Integer>> dsf = new ArrayList<>(sad.entrySet());
        Collections.sort(dsf, new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                return (Integer) o1.getKey()-(Integer)o2.getKey();
            }
        });
        int pointer = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : dsf) {
            Integer value = integerIntegerEntry.getValue();
            Integer key = integerIntegerEntry.getKey();
            for(int i = 0;i < value;i++){
                nums[pointer] = key;
                pointer++;
            }
        }
        System.out.println("");
    }
    /**
     * best
     */
    public void sortColors2(int[] nums) {
        // 1-pass
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }
}
