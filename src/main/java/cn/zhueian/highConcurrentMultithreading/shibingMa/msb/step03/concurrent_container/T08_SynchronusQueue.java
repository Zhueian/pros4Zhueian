package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step03.concurrent_container;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @Auther: qiucy
 * @Date: 2019-04-27 18:53
 * @Description:
 *  一种特殊的TransferQueue();容量为零！标志性的队列
 *
 */
public class T08_SynchronusQueue {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue<>();
        //先启动消费者
        new Thread(() -> {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            //底层就是Transfer();阻塞
            //add(),会throws FullEx
            queue.put("aaa");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
