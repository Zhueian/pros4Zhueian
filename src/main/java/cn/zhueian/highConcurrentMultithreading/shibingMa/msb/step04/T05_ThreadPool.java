package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-04-28 13:49
 * @Description:
 *  从lambda表达式引用的本地变量必须是最终变量或实际上的最终变量!
 *  TODO sout(service)->task queue一般都是BlockingQueue();为什么不用BlockingQueue
 *  TODO 400这期的tank会用nio写服务器吗？
 *  还维护一个completed task queue;
 *  闲着的线程statue：idot，发呆
 *  statue：running ;shutting down ;terminal
 */
public class T05_ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
//        Executor service2 = Executors.newFixedThreadPool(5);
        //execute()自动调用run()
//        for (int i = 0; i < 6; i++) {
//            service.execute(() -> {
//                System.out.println(Thread.currentThread().getName()+"_sad_");
//            });
//        }
        for (int i = 0; i < 6; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"_asda");
                }
            });
        }
        System.out.println("service:"+service);
        //线程池关闭，会阻塞,等待task queue为0，任务结束为止。
        service.shutdown();
        //线程池二话不说关闭，不阻塞
        service.shutdownNow();
        //指是否每个任务都执行完了。
        System.out.println("service.isTerminated():"+service.isTerminated());
        System.out.println("service.isShutdown():"+service.isShutdown());
        System.out.println("service:"+service);
        TimeUnit.SECONDS.sleep(5);
        System.out.println("service.isTerminated():"+service.isTerminated());
        System.out.println("service.isShutdown():"+service.isShutdown());
        System.out.println("service:"+service);
    }
}
