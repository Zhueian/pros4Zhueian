package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Auther: qiucy
 * @Date: 2019-04-28 15:08
 * @Description:
 *  并行计算的小程序：计算200000之内的所有素数，getPrime();
 *  千万级poi to excel:长时间阻塞就不是宽带的问题了
 *  TODO Future submit callable怎么指定线程名。
 *  TODO 用countdownLatch();
 */
public class T07_ParallelComputing {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> primes = null;
        long start = System.currentTimeMillis();
//        primes = simpleMethod(200000);
        primes = parallelComputing(200000);
        System.out.println(primes);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static List<Integer> parallelComputing(int i) throws ExecutionException, InterruptedException {
        List<Integer> result = new ArrayList<>();

//        result.addAll(getPrimes(1,80000));
//        result.addAll(getPrimes(80001,130000));
//        result.addAll(getPrimes(130001,175000));
//        result.addAll(getPrimes(175001,190000));
//        result.addAll(getPrimes(190001,200000));

//        ExecutorService service = Executors.newFixedThreadPool(5);
//        Future<List<Integer>> submit = service.submit(() -> {
//            List<Integer> sub = new ArrayList<>();
//
//            return sub ;
//        });

        FutureTask<List<Integer>> f1 = new FutureTask<List<Integer>>(new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                long s = System.currentTimeMillis();
                List<Integer> r = getPrimes(1, 80000);
                long e = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName()+"=="+(e - s));
                return (r);
            }
        });
        FutureTask<List<Integer>> f2 = new FutureTask<List<Integer>>(new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                long s = System.currentTimeMillis();
                List<Integer> r = getPrimes(80001,130000);
                long e = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName()+"=="+(e - s));
                return (r);
            }
        });
        FutureTask<List<Integer>> f3 = new FutureTask<List<Integer>>(new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                long s = System.currentTimeMillis();
                List<Integer> r = getPrimes(130001,175000);
                long e = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName()+"=="+(e - s));
                return (r);
            }
        });
        FutureTask<List<Integer>> f4 = new FutureTask<List<Integer>>(new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                long s = System.currentTimeMillis();
                List<Integer> r = getPrimes(175001,190000);
                long e = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName()+"=="+(e - s));
                return (r);
            }
        });
        FutureTask<List<Integer>> f5 = new FutureTask<List<Integer>>(new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                long s = System.currentTimeMillis();
                List<Integer> r = getPrimes(190001,200000);
                long e = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName()+"=="+(e - s));
                return (r);
            }
        });
        new Thread(f1,"t1").start();
        new Thread(f2,"t2").start();
        new Thread(f3,"t3").start();
        new Thread(f4,"t4").start();
        new Thread(f5,"t5").start();
        result.addAll(f1.get());
        result.addAll(f2.get());
        result.addAll(f3.get());
        result.addAll(f4.get());
        result.addAll(f5.get());
        return result;
    }

    private static List<Integer> getPrimes(int start, int end) {
        List<Integer> sub_result = new ArrayList<>();
        a:for (int i = start; i <= end; i++) {
//            b:for (int j = 2; j < i; j++) {
            b:for (int j = 2; j <= i/2; j++) {
                if(i % j == 0) continue a;
            }
            sub_result.add(i);
        }
        return sub_result;
    }

    private static List<Integer> simpleMethod(int i) {
        List<Integer> result = new ArrayList<>();
        a:for (int j = 2; j <= i; j++) {
            b:for (int k = 2; k < j; k++) {
//            b:for (int k = 2; k <= j/2; k++) {
                if(j % k == 0){
                    continue a;
                }
            }
            result.add(j);
        }
        return result;
    }
}
