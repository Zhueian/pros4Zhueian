package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Auther: qiucy
 * @Date: 2019-04-28 16:35
 * @Description:老马源码,并行计算
 */
public class T07_ParallelComputing_src {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        System.out.println(Runtime.getRuntime().totalMemory());
//        System.out.println(System.getProperties());
        long start = System.currentTimeMillis();
        List<Integer> result = getPrime(1,200000);
        long end = System.currentTimeMillis();
        System.out.println("firstTime="+(end - start));
        //查看cpu核数
        System.out.println("cpuCoreNum_"+Runtime.getRuntime().availableProcessors());
        final int cpuCoreNum = 4;
        ExecutorService service = Executors.newFixedThreadPool(cpuCoreNum);

        //要是 内部类 没有static就得一下写法，比较麻烦；
//        new T07_ParallelComputing_src().new Mytask(1,80000);

        start = System.currentTimeMillis();
        Mytask t1 = new Mytask(1, 80000);
        Mytask t2 = new Mytask(80001, 130000);
        Mytask t3 = new Mytask(130001, 170000);
        Mytask t4 = new Mytask(170001, 200000);
        Future<List<Integer>> r1 = service.submit(t1);
        Future<List<Integer>> r2 = service.submit(t2);
        Future<List<Integer>> r3 = service.submit(t3);
        Future<List<Integer>> r4 = service.submit(t4);
        result.addAll(r1.get());
        result.addAll(r2.get());
        result.addAll(r3.get());
        result.addAll(r4.get());
        end = System.currentTimeMillis();
        System.out.println("secondTime="+(end - start));
    }
    static class Mytask implements Callable<List<Integer>>{
        int start,end;
        @Override
        public List<Integer> call() throws Exception {
            List<Integer> r = getPrime(start,end);
            return r;
        }
        public Mytask(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    private static List<Integer> getPrime(int start, int end) {
        List<Integer> sub_result = new ArrayList<>();
        for(int i = start;i <= end;i++){
            if(isPrime(i)) sub_result.add(i);
        }
        return sub_result;
    }

    private static boolean isPrime(int num) {
        for (int j = 2; j <= num/2; j++) {
            if(num % j == 0) return false;
        }
        return true;
    }
}
