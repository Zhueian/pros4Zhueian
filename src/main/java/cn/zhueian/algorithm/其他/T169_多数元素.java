package cn.zhueian.algorithm.其他;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by qiucy on 2019/12/3.
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 示例 1:
 */
public class T169_多数元素 {
    public int majorityElement(int[] nums) {
        int res = 0;
        int length = nums.length;
        int n = length/2;
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < length; i++) {
            boolean b = m.containsKey(nums[i]);
            if (b){
                m.put(nums[i],m.get(nums[i])+1);
            }else{
                m.put(nums[i],1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = m.entrySet();
        Iterator<Map.Entry<Integer, Integer>> it = entries.iterator();
        while (it.hasNext()){
            Map.Entry<Integer, Integer> next = it.next();
            if (next.getValue()>n) return next.getKey();
        }
        return res;
    }

    /**
     * best O(n) time O(1) space fastest solution
     * @return
     */
    public int majorityElement2(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;

        }
        return major;
    }

    public static void main(String[] args) {
        System.out.println(1/2);
    }
}
