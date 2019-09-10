package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step03.concurrent_container;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Auther: qiucy
 * @Date: 2019-04-26 13:02
 * @Description:生产者消费者，解藕，
 *  Blocking:之前的demo;
 *  容器满了，生产者线程product_condition.await(),custom_condition.singleAll();
 *  容器空了，消费者线程custom_condition.await(),product_condition.singleAll();
 *
 *  BlockingQueue.take()/put(),都是空了/满了会阻塞，jdk给实现了。注意ArrayBlckingQueue是有界会满的，LinkedBlockingQueue是无界的，基本不可能满。
 * TODO ConcurrentQueue和BlockingQueue区别：
 */
public class T04_LinkedBlockingQueue {
//    static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);
    //老马src
    static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
    static Random r = new Random();

    public static void main(String[] args) {
        //生产者
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                    //            for (int i = 0; i < 100; i++) {
                    //                try {
                    //                    //阻塞
                    //                    queue.put(" bean_"+i);
                    //                    TimeUnit.MILLISECONDS.sleep(100);
                    //
                    //                } catch (InterruptedException e) {
                    //                    e.printStackTrace();
                    //                }
                    //            }
                    //            int k = 0;
                    //            while (true){
                    for(int k = 0;;k++){
                        try {
                            //阻塞
                            queue.put(Thread.currentThread().getName()+" put bean_"+(++k));
                            //                    TimeUnit.MILLISECONDS.sleep(100);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                },"product_"+i).start();
            }

        //消费者
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for(;;){
                    try {
                        System.out.println(Thread.currentThread().getName()+" get "+queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"custom_"+i).start();
        }
    }
}
