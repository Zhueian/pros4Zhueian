package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step04;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Auther: qiucy
 * @Date: 2019-04-28 13:42
 * @Description:
 *  等同于Arrays，Collections操作xxx的工具类；
 *  操作线程执行器的工具类；
 *  多为static方法
 */
public class T04_Executors {
    public static void main(String[] args) {
        ThreadFactory t = Executors.defaultThreadFactory();
        t.newThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"_sdsdsd");
            }
        }).start();
    }
}
