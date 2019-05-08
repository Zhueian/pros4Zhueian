package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step03.concurrent_container;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-04-26 14:01
 * @Description:有界阻塞队列
 */
public class T05_ArrayBlockingQueue {
    static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
    static Random r = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            queue.offer("a"+r.nextInt(100));
        }
        //throws exception
        queue.add("bbb");
        //按时间段阻塞
        try {
            queue.offer("aaa",1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //不阻塞，不throws ex
        queue.offer("aaa");
        //阻塞
        try {
            queue.put("ccc");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(queue);
    }
}
