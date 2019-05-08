package cn.zhueian.leetcode.leetcode.ac;

import java.util.Scanner;

/**
 * @Auther: qiucy
 * @Date: 2018-12-26 00:53
 * @Description:
 */
public class L1_SumOfTwo {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    private static Scanner sc = new Scanner(System.in);
    /**
     *
     * Description of method :
     *
     * @param:
     * @return:
     * @auther: qiucy
     * @date: 2018-12-26 00:57
     */
    public static void main(String[] args) {
        L1:while(true){
            String in = sc.nextLine();
            if(in.equals("-1")) {
                break L1;
            }
            String[] strTemp1 = in.trim().split("], target = ");
            int target = Integer.parseInt(strTemp1[1]);
            String[] strTemp2 = strTemp1[0].split(" = ");
            String[] strTemp3 = strTemp2[1].split(",");
            int[] nums = new int[strTemp3.length];
            for(int i = 0;i < strTemp3.length;i ++){
                if(i == 0){
                    nums[i] = Integer.parseInt(strTemp3[i].trim().substring(1));
                }else{
                    nums[i] = Integer.parseInt(strTemp3[i].trim());
                }
            }
            L2:for(int i = 0;i < strTemp3.length-1;i ++){
                for(int j = i+1;j < strTemp3.length;j ++){
                    if((nums[i] + nums[j]) == target){
                        System.out.println("["+i+", "+j+"]");
                        continue L1;
                    }
                }
            }
            System.out.println("exit!");
        }
    }

}
