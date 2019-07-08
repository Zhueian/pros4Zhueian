package cn.zhueian.algorithm.greedy;

/**
 * @Auther: qiucy
 * @Date: 2019-07-05 11:24
 * @Description:
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 
 * 朵花？能则返回True，不能则返回False。
 * 示例 1:
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 * 1,0,0,0,1
 */
public class T605_种花 {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = flowerbed.length,count = 0,r = 0;
        for (int i = 0; i < l; i++) {
            if (flowerbed[i] == 0) count++;
            //居中,起码有三个0，以1结束，不是左倾斜
            boolean mid = count >=3 && flowerbed[i] == 1 && count != i;
            //左右倾斜,起码2个0，右倾斜或左倾斜
            boolean lr = count >=2 && ((i == l-1 && flowerbed[i] == 0)||((flowerbed[i] == 1) && count == i));
            //全量
            boolean all = count >= 1 && i == l-1 && count == l;
            if (count>=1){
                //居中
                if (mid){
                    r+=count%2 == 0?(count-2)/2:(count-1)/2;
                }
                //左右倾斜
                if (lr){
                    r+=(count%2 == 0?(count)/2:(count-1)/2);
                }
                //全量倾斜
                if (all){
                    r = count%2 == 0?count/2:(count+1)/2;
                }
            }
            if (flowerbed[i] == 1) count = 0;
        }
        return r>=n;
    }

    public static void main(String[] args) {
        int[] r = {1,0,0,0,1,0,0};
        T605_种花.canPlaceFlowers(r,2);
    }
}
