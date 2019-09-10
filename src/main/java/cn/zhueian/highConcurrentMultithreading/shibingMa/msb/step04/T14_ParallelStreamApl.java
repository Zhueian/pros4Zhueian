package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Auther: qiucy
 * @Date: 2019-04-30 10:25
 * @Description:
 *  判断一串数里面的质数
 *  比较最慢和ParallelStreamApi的区别
 *  数据越大没效率差别越大；
 *
 *TODO .parallelStreamAPI多线程怎么切换分配任务的。
 *TODO 了解parallelStreamAPI
 */
public class T14_ParallelStreamApl {
    private static List<Integer> list = new ArrayList<>();
    private static Random r  = new Random();
    static{
        long start = System.currentTimeMillis();
//        for (int i = 0; i < 1000000; i++) list.add(r.nextInt(r.nextInt(1000000)));
        for (int i = 0; i < 1000000; i++) list.add(r.nextInt(1000000));
        long end = System.currentTimeMillis();
        System.out.println("list size = "+list.size()+" create nums user time = "+(end - start));
    }
    public static void main(String[] args) {
        System.out.println("asda");
        long start = System.currentTimeMillis();
        List<Integer> primes = new ArrayList<>();
        list.forEach(t->isPrime(t));
//        list.parallelStream
        long end = System.currentTimeMillis();
        System.out.println("simple method user time = "+(end - start));
        start = System.currentTimeMillis();
        list.parallelStream().forEach(T14_ParallelStreamApl::isPrime);
        end = System.currentTimeMillis();
        System.out.println("parallel method user time = "+(end - start));
    }
    private static boolean isPrime(int x){
        if(x <= 1) return  false;
        for (int i = 2; i < x/2; i++) {
            if(x % i == 0) return false;
        }
        return true;
    }
}
