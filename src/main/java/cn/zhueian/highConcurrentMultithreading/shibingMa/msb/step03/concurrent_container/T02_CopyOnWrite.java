package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step03.concurrent_container;

import java.util.*;

/**
 * @Auther: qiucy
 * @Date: 2019-04-26 11:13
 * @Description:写时复制
 *  多线程下，写效率低，读效率高适合写少读多的逻辑业务。
 *  读都不加锁，但是写操作加锁然后用复制一个新的容器来替代引用，所以写效率不高，复制就是内存容易溢出，时间效率也不高。
 *  ReadLock和WriteLock，由词知意，一个读锁一个写锁，合称“读写锁”。再进一步观察可以发现ReadLock和WriteLock是靠内部类Sync实现的锁。
 *  Sync是AQS的一个子类，这种结构在CountDownLatch、ReentrantLock、Semaphore里面也都存在
 *  实现原理：
 *      在最开始提及AQS的时候我们也提到了state字段（int类型，32位），该字段用来描述有多少线程获持有锁。
        在独享锁中这个值通常是0或者1（如果是重入锁的话state值就是重入的次数），在共享锁中state就是持有锁的数量。
     但是在ReentrantReadWriteLock中有读、写两把锁，所以需要在一个整型变量state上分别描述读锁和写锁的数量（或者也可以叫状态）。
     于是将state变量“按位切割”切分成了两个部分，高16位表示读锁状态（读锁个数），低16位表示写锁状态（写锁个数
 */
public class T02_CopyOnWrite {
    public static void main(String[] args) {
        List<String> list =
//                    new Vector<>();

//                    new CopyOnWriteArrayList<>();
        //TODO 分析size ！= 100000的原因 和
                // Exception in thread "t_5" java.lang.ArrayIndexOutOfBoundsException:
                // Index 2782 out of bounds for length 2776：27行
                    new ArrayList<>();
        Random random = new Random();
        Thread[] ths = new Thread[100];
        for (int i = 0; i < 100; i++) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) list.add("ranVal_"+random.nextInt(10000));
                }
            };
            ths[i] = new Thread(r,"t_"+i);
        }
        runAndCompared(ths);
        System.out.println("size = "+list.size());
    }
    private static void runAndCompared(Thread[] ths){
        long start = System.currentTimeMillis();
        Arrays.asList(ths).forEach(t->t.start());
        Arrays.asList(ths).forEach(t-> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        System.out.println("time = "+(end - start));
    }
}
