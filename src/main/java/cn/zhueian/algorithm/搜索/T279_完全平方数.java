package cn.zhueian.algorithm.搜索;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Created by qiucy on 2019/10/8.
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）
 * 使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class T279_完全平方数 {
    /**
     * 贪心不行啊
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int mid = n / 2;
        int r = 0;
        for (int i = mid; i > 0; i--) {
            if (i * i > n) continue;
            else {
                r++;
                n -= i * i;
            }
        }
        return r;
    }

    /**
     * @param n
     * @return
     */
    public int numSquares2(int n) {
        int mid = n / 2;
        for (int i = mid; i > 1; i--) {

        }
        return 0;
    }

    public int t3(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int s : squares) {
                    int next = cur - s;
                    if (next < 0) {
                        break;
                    }
                    if (next == 0) {
                        return level;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return n;
    }

    /**
     * 生成小于 n 的平方数序列
     *
     * @return 1, 4, 9, ...
     */
    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }



    /**
     * 四平方定理
     * @param n
     * @return
     * 利用四平方和定理：任何一个整数都可以表示为不超过4个数的平方和
       推论：当且仅当n=4^a(8b+7)时，n恰好可以表示为4个数的平方和
     */
    public int t4(int n){
        while(0 == n%4) n /= 4;
        if (7 == n%8) return 4;
        for (int i = 0;i*i < n;++i){
            int j = (int)Math.pow(n-i*i,0.5);
            if (n == i*i + j*j) return 0;
        }
        return 3;
    }

    /**
     * bfs之一
     * @param n
     * @return
     */
    public int numSquares3(int n) {
        // 用于存放组成n的，平方数
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        // 用于判断那些平方数已经放入队列
        boolean record[] = new boolean[n];
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            step++;
            while(size-- > 0){
                int val = queue.poll();
                for(int i=1; val-i*i>=0; i++){
                    int nextVal = val - i * i;
                    // 组成数值都已经分为子数
                    if(nextVal == 0)
                        return step;
                    // 假如当前组成平方数的数字已经存放到record中， 当前组成数字一定大于之前的那种情况
                    if(!record[nextVal]){
                        queue.add(nextVal);
                        record[nextVal] = true;
                    }
                }
            }
        }
        return -1;
    }











    public static void main(String[] args) {
        T279_完全平方数 t = new T279_完全平方数();
//        System.out.println(t.numSquares3(3));
//        System.out.println(t.numSquares3(4));
//        System.out.println(t.numSquares3(5));
//        System.out.println(t.numSquares3(6));
//        System.out.println(t.numSquares3(7));
//        System.out.println(t.numSquares3(8));
        System.out.println(t.numSquares3(8));
        System.out.println(t.get(13));
    }


    /**
     * test
     * @param n
     * @return
     */
    public int get(int n){
        Queue<Integer> afterQuares = new LinkedList<>();
        afterQuares.add(n);
        boolean[] recored = new boolean[n];
        int res = 0;
        while (!afterQuares.isEmpty()){
            res++;
            int size = afterQuares.size();
            while (size-- > 0){
                Integer val = afterQuares.poll();
                for (int i = 1;val-i*i>=0;i++){
                    int nextVal = val - i*i;
                    if (nextVal == 0) return res;
                    if (!recored[nextVal]){
                        afterQuares.add(nextVal);
                        recored[nextVal] = true;
                    }
                }
            }
        }
        return -1;
    }



}
