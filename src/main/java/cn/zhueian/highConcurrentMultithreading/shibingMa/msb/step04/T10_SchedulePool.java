package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step04;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-04-28 17:37
 * @Description:
 *  DelayQueue实现的执行定时任务的线程池。、；
 *  Schedule:排好表格的，计划中的，按时间规则的
 *  替代Timer，相比Timer，线程可以复用，Timer每次都new Thread，效率高点吧
 *  TODO 时间逻辑与边际值捋清楚！
 */
public class T10_SchedulePool {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
        //0:表示延时多少毫秒执行，0为立即执行，延时0毫秒
        //500：周期为500ms
        service.scheduleAtFixedRate(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },0,500, TimeUnit.MILLISECONDS);
    }
}
