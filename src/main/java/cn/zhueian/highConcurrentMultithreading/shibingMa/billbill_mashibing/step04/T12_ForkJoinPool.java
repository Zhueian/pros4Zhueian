package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step04;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @Auther: qiucy
 * @Date: 2019-04-29 00:16
 * @Description:
 *  计算一千万长度数组的和
 *  比较多个方案的时常。
 *  TODO 真不懂啊这个。。。细读api
 *  递归过程forkjoin维护，递归规则自己定义！
 *  myTask extends RecuriseAction/RecuriseTask<V>
 */
public class T12_ForkJoinPool {
    private static int[] test = new int[10000000];
    private static int initTime = 0;
//    private static int[] test = new int[1000000];
    private static Random r = new Random();
    static {
        for (int i = 0; i < test.length; i++) {
            test[i] = r.nextInt(100);
        }
        System.out.println("static compute sum = "+Arrays.stream(test).sum());
//        System.out.println("static compute sum = "+Arrays.parallelStest).sum());
    }
    //无返回值递归,,注意没有return所以没有join();这个方法有点Runnable与Callable<V>区别的味道
//    static class Mytask extends RecursiveAction{
//        private int rightIndex,leftIndex;
//
//        public Mytask(int rightIndex, int leftIndex) {
//            this.rightIndex = rightIndex;
//            this.leftIndex = leftIndex;
//        }
//
//        @Override
//        protected void compute() {
//            if(rightIndex - leftIndex <= 500000){
//                Long sum = 0L;
//                for (int i = leftIndex;i < rightIndex;i++) sum += test[i];
//                System.out.println("from:"+leftIndex+" to:"+rightIndex);
//            }else{
//                int mid = leftIndex + (rightIndex - leftIndex);
//                Mytask sub_mytask1 = new Mytask(leftIndex, mid);
//                Mytask sub_mytask2 = new Mytask(mid, rightIndex);
//                sub_mytask1.fork();
//                sub_mytask2.fork()
//            }
//        }
//    }
    //有返回值递归
    static class Mytask extends RecursiveTask<Long>{
        private int leftIndex,rightIndex;

        public Mytask(int leftIndex, int rightIndex) {
            this.rightIndex = rightIndex;
            this.leftIndex = leftIndex;
//            initTime++;
//            System.out.println("Mystask init...time = "+(initTime));
        }

        @Override
        protected Long compute() {
//            if(leftIndex - rightIndex <= 50000){
            if(rightIndex - leftIndex <= 500000){
                Long result = 0L;
                for (int i = leftIndex; i < rightIndex ; i++) {
                    result += test[i];
                }
//                System.out.println(test[leftIndex]+"::"+test[rightIndex-1]);
//                System.out.println(Thread.currentThread().getName()+" from:"+leftIndex+" to:"+rightIndex+" = "+result);
                return result;
            }
            int mid = leftIndex + (rightIndex - leftIndex)/2;
            Mytask sub_mytask1 = new Mytask(leftIndex, mid);
            Mytask sub_mytask2 = new Mytask(mid, rightIndex);
            //一旦一个fork()  就是一个新的线程启动了。
            //TODO 细读fork()怎么递归的？
            sub_mytask1.fork();
            sub_mytask2.fork();

            return sub_mytask1.join()+sub_mytask2.join();
        }
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        Long simpleResult = 0L;
        for (int i = 0; i < test.length; i++) simpleResult+=test[i];
        long end = System.currentTimeMillis();
        System.out.println("simpleResult = "+simpleResult+" user time = "+(end - start));
        start = System.currentTimeMillis();
//        System.out.println(test.length+"::"+test[1]+","+test[9999999]);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Mytask mytask = new Mytask(0,test.length);
//        forkJoinPool.execute(mytask);
        //这个不用阻塞主线程...虽然都是daemon线程。
        //这个join无返回值
//        new Thread().join()
//        Long result = mytask.join();
//        end = System.currentTimeMillis();
//        System.out.println("forkJoinResult = "+result+" user time = "+(end - start));

        //execute()   submit()   task.join()    task.gei()   一样的

        ForkJoinTask<Long> submit = forkJoinPool.submit(mytask);
        //RecuriseAction的没有join()!
        Long join = submit.join();
        Long aLong = submit.get();
        end = System.currentTimeMillis();
        System.out.println("Long"+join+" aLong = "+aLong);
        System.out.println("forkJoinResult = "+join+" user time = "+(end - start));
//        submit.join();
//        mytask.join();
        //这个不用阻塞主线程...虽然都是daemon线程。
//        System.out.println("submit.get() = "+submit.get());
    }
}
