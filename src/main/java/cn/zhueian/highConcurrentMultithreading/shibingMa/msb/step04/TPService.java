package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step04;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.*;

@Service
//@Slf4j
public class TPService {

//    @Autowired
//    @Qualifier("ikafkaTemplate")
//    private KafkaTemplate kafkaTemplate;
//
//    @Autowired
//    private CustomerInfoManager customerInfoManager;
    //IObound
    private final static int TASKNUM = 1024 * 8, THEADNUM = Runtime.getRuntime().availableProcessors() * 2 + 2;
    private static volatile ExecutorService exec = null;

    static {
        ThreadFactory tpFac = new ThreadFactoryBuilder().setNameFormat("msgThreadPool4Kafk-%d").build();
        exec = new ThreadPoolExecutor
                (THEADNUM, THEADNUM, 0L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(TASKNUM), tpFac,
                        new ThreadPoolExecutor.
                                //1.先将阻塞队列中的头元素出队抛弃，再尝试提交任务。如果此时阻塞队列使用PriorityBlockingQueue优先级队列，
                                // 将会导致优先级最高的任务被抛弃，因此不建议将该种策略配合优先级队列使用
                        /*DiscardOldestPolicy()*/
                        //2.既不抛弃任务也不抛出异常，直接运行任务的run方法，换言之将任务回退给调用者来直接运行。使用该策略时线程池饱和后将由调用线程池的主线程自己来执行任务，
                                // 因此在执行任务的这段时间里主线程无法再提交新任务，从而使线程池中工作线程有时间将正在处理的任务处理完成。
                        /*CallerRunsPolicy()*/
                        //3.使用该策略时在饱和时会抛出RejectedExecutionException（继承自RuntimeException），调用者可捕获该异常自行处理。
                        /*AbortPolicy()*/
                        //4.不做任何处理直接抛弃任务，mbp-account，mbp-launch用的就是这
                        DiscardPolicy()
                );
    }
    //监控线程
    private TPService() {
        //线程池监控
        Thread monitor_thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    log.info("execute status:"+exec);
                    boolean shutdown = exec.isShutdown();
                }
            }
        },"monitor_thread");
        //这个语言上过得去，这个Service被回收了，也就是线程池关闭了，那这个fork出去的线程夜的跟着回收，生命周期不会过长，影响占着资源
        monitor_thread.setDaemon(true);
        monitor_thread.start();
    }

    /**
     * final小插曲：6/7jdk以前m是要加fianl的，是因为内部类和外部类同级的，编译后：Outer.class,$Iner.class两个文件，
       所以不共域还是指令优化怎么着，匿名内部类读到外部类的传值为null，加fianl能保证赋值在顺序前，且不变性让其怎么优化都行
       TODO mbp-portal-web是jdk1.8的带还是要final
     * @param m
     */
    public void e1(Map<String, Object> m) {
        try {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    m.getOrDefault("a","b");
                }
            });
        } catch (Exception e) {
//            log.error("synMsg4Kafk meet error:", e);
        }
    }
}