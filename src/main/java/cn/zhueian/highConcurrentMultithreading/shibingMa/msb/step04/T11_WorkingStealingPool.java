package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step04;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * @Auther: qiucy
 * @Date: 2019-04-28 17:52
 * @Description:
 *  工作窃取线程池；
 *  每个线程都维护自己的任务队列；
 *  当一个线程把自己的任务队列的是清空了，会去偷取别的线程的不为空的任务队列里的任务；
 *  主动找活干；
 *  用 ForkJoinPool() 实现的；
 *  产生的精灵线程/守护线程，主线程不能挂，要阻塞着，jvm不能关！
 *  daemon thread - xxoo
 *  工作窃取线程池默认：线程数=cpuCoreNum->Runtime,getRuntime.avorityProcessor();
 *  TODO 这个写法跟Executors.newFixThreadPool()有啥区别？？这demo没有体现一个线程维护一个队列的模型。。。
 */
public class T11_WorkingStealingPool {
    private static int time = 0;
    public static void main(String[] args) {
        System.out.println("cpuCoreNum_="+Runtime.getRuntime().availableProcessors());
        ExecutorService service = Executors.newWorkStealingPool();
        for (int i = 0; i < 1100; i++) {
            time += 500;
            service.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName()+" time = "+time);
                    TimeUnit.MILLISECONDS.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
//            Future<Integer> submit = service.submit(() -> {
//                return 3;
//            });
            //因为是daemon线程，所以的zuse

        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
