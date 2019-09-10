package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-04-28 17:32
 * @Description:
 *  单线程池。。。没啥蛋用;
 *  不必解释了。
 *  newSingleThreadExcutor == newFixThreadExecutor(1)
 *  保证任务前后执行吧 ...
 */
public class T09_newSingleThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            service.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        service.shutdown();
    }
}
