package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-04-28 17:14
 * @Description:
 *  刚开始一个线程都没有，默认线程idot时间60s,线程销毁;
 *  live_time = 60s
 *  系统支撑几万线程没啥问题！构造看出最大：Integer.MAX_VALUE
 *  实现可能是LinkedBlockingQueue();
 *  TODO rtmp嘛玩意?
 */
public class T08_CacheThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println(service);
        for (int i = 0; i < 2; i++) {
            service.submit(() -> {
//            service.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println(service);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(service);
        service.shutdown();
    }
}
