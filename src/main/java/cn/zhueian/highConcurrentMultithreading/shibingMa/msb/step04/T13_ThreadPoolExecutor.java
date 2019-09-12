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
    //linux的较低版本内核调度函数src,java线程调度有优先级，但体现得不明显；
    //猜测：jvm是上层应用，现在普通os是无法识别也还没能学习识别上层应用IOBound和CPUBound
    // 这个倒是很明显，比如鼠标得硬件中断，优先级极高
//    void _schedule(void){
//        while(1){
//            c = -1,next = 0,i = NR_TASK,p = &task[NR_TASK];
//            while (--i){
                  //这个counter是时间片
//                if ((*p->state == TASK_RUNNING) && (*p)->counter>c)
//                    c = (*p)->counter,next = i;
//            }
              //找到时间片最大得跳出，很明显IOBound得时间片都很小，但优先级高；
//            if (c) break;
//            for (p = &LAST_TASK;p>&FIRST_TASK;--p)
                  //这个counter是优先级。
                  // 算法很妙，调度算法出发是很频繁得，所以必须时空O要小，一个counter即是时间片变量也是优先级变量，一个进程只需维护一个变量；
                  //又移保证优先级是有界收敛，不会无限大，不至于存在优先级无限小的程序，永远没法得到时间片。O:c(t)=c(t-1)/2+p;c(0)=p,,ps：看着像机器学习我操
//                (*p) -> counter = ((*p)->counter>>1)+(*p)->priority;
              //切换
//            switch_to(next);
//
//        }
//    }
}
