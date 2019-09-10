package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step04;

import java.util.concurrent.*;

/**
 * @Auther: qiucy
 * @Date: 2019-04-30 10:00
 * @Description:
 *  所有线程池背后的类,
 *      newFixThreadPool;->new ThreadPoolExecutor(...new LinkedBlockingQueue<Runnable>)
 *      newCacheThreadPool;->new ThreadPoolExecutor(...new SynchrousQueue<Runnable>->BlockingQueue<Runnable>,任务队列容量为零)
 *      newSingleThreadPool;->new ThreadPoolExecutor(...new LinkedBlockingQueue<Runnable>)
 *      newSchudePool;->new ThreadPoolExecutor(...new DelayWorkQueue=>BlockingQueue<Runnable>)
 *  除了这两以外：直接继承defaultThreadPool.
 *      WorkeStealingPool;
 *      ForkJoinPool;
 *
 *  自定义用的;
 *  TODO 线程池为什么不能用非阻塞式的？？
 *  TODO 为什么用Linked不用Array
 */
public class T13_ThreadPoolExecutor {
    public static void main(String[] args) {
        //观察一下API
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(2,2,0L, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
        new SynchronousQueue<Runnable>();
        new ConcurrentLinkedQueue<Runnable>();
    }
}
